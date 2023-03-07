package diagnostics

import (
	"encoding/json"
	"fmt"
	"log"
	"os"
	"strings"
	"time"
)

type sourceStruct struct {
	Id            string `json:"id"`
	Name          string `json:"name"`
	ExtractorName string `json:"extractorName"`
}

type diagnosticSeverity string

const (
	severityError   diagnosticSeverity = "error"
	severityWarning diagnosticSeverity = "warning"
	severityNote    diagnosticSeverity = "note"
)

type visibilityStruct struct {
	StatusPage      bool `json:"statusPage"`      // True if the message should be displayed on the status page (defaults to false)
	CliSummaryTable bool `json:"cliSummaryTable"` // True if the message should be counted in the diagnostics summary table printed by `codeql database analyze` (defaults to false)
	Telemetry       bool `json:"telemetry"`       // True if the message should be sent to telemetry (defaults to false)
}

type locationStruct struct {
	File        string `json:"file,omitempty"`
	StartLine   int    `json:"startLine,omitempty"`
	StartColumn int    `json:"startColumn,omitempty"`
	EndLine     int    `json:"endLine,omitempty"`
	EndColumn   int    `json:"endColumn,omitempty"`
}

type diagnostic struct {
	Timestamp       string           `json:"timestamp"`
	Source          sourceStruct     `json:"source"`
	MarkdownMessage string           `json:"markdownMessage"`
	Severity        string           `json:"severity"`
	Internal        bool             `json:"internal"`
	Visibility      visibilityStruct `json:"visibility"`
	Location        *locationStruct  `json:"location,omitempty"` // Use a pointer so that it is omitted if nil
}

var diagnosticsEmitted, diagnosticsLimit uint = 0, 100
var noDiagnosticDirPrinted bool = false

func emitDiagnostic(sourceid, sourcename, markdownMessage string, severity diagnosticSeverity, internal, visibilitySP, visibilityCST, visibilityT bool, file string, startLine, startColumn, endLine, endColumn int) {
	if diagnosticsEmitted < diagnosticsLimit {
		diagnosticsEmitted += 1

		diagnosticDir := os.Getenv("CODEQL_EXTRACTOR_GO_DIAGNOSTIC_DIR")
		if diagnosticDir == "" {
			if !noDiagnosticDirPrinted {
				log.Println("No diagnostic directory set, so not emitting diagnostic")
				noDiagnosticDirPrinted = true
			}
			return
		}

		var optLoc *locationStruct
		if file == "" && startLine == 0 && startColumn == 0 && endLine == 0 && endColumn == 0 {
			optLoc = nil
		} else {
			optLoc = &locationStruct{file, startLine, startColumn, endLine, endColumn}
		}
		d := diagnostic{
			time.Now().UTC().Format("2006-01-02T15:04:05.000") + "Z",
			sourceStruct{sourceid, sourcename, "go"},
			markdownMessage,
			string(severity),
			internal,
			visibilityStruct{visibilitySP, visibilityCST, visibilityT},
			optLoc,
		}

		if diagnosticsEmitted == diagnosticsLimit {
			d = diagnostic{
				time.Now().UTC().Format("2006-01-02T15:04:05.000") + "Z",
				sourceStruct{"go/autobuilder/diagnostic-limit-hit", "Some diagnostics were dropped", "go"},
				fmt.Sprintf("The number of diagnostics exceeded the limit (%d); the remainder were dropped.", diagnosticsLimit),
				string(severityWarning),
				false,
				visibilityStruct{true, true, true},
				nil,
			}
		}

		content, err := json.Marshal(d)
		if err != nil {
			log.Println(err)
		}

		targetFile, err := os.CreateTemp(diagnosticDir, "go-extractor.*.jsonl")
		if err != nil {
			log.Println("Failed to create temporary file for diagnostic: ")
			log.Println(err)
		}
		defer func() {
			if err := targetFile.Close(); err != nil {
				log.Println("Failed to close diagnostic file:")
				log.Println(err)
			}
		}()

		_, err = targetFile.Write(content)
		if err != nil {
			log.Fatal(err)
		}
	}
}

func EmitPackageDifferentOSArchitecture(pkgPath string) {
	emitDiagnostic("go/autobuilder/package-different-os-architecture",
		"Package "+pkgPath+" is intended for a different OS or architecture",
		"Make sure the `GOOS` and `GOARCH` [environment variables are correctly set](https://docs.github.com/en/actions/learn-github-actions/variables#defining-environment-variables-for-a-single-workflow). Alternatively, [change your OS and architecture](https://docs.github.com/en/actions/using-github-hosted-runners/about-github-hosted-runners#using-a-github-hosted-runner).",
		severityWarning, false,
		true, true, true,
		"", 0, 0, 0, 0,
	)
}

const maxNumPkgPaths = 5

func EmitCannotFindPackages(pkgPaths []string) {
	numPkgPaths := len(pkgPaths)

	ending := "s"
	if numPkgPaths == 1 {
		ending = ""
	}

	numPrinted := numPkgPaths
	truncated := false
	if numPrinted > maxNumPkgPaths {
		numPrinted = maxNumPkgPaths
		truncated = true
	}

	secondLine := "`" + strings.Join(pkgPaths[0:numPrinted], "`, `") + "`"
	if truncated {
		secondLine += fmt.Sprintf(" and %d more", numPkgPaths-maxNumPkgPaths)
	}

	emitDiagnostic(
		"go/autobuilder/package-not-found",
		fmt.Sprintf("%d package%s could not be found", numPkgPaths, ending),
		"The following packages could not be found. Check that the paths are correct and make sure any private packages can be accessed. If any of the packages are present in the repository then you may need a [custom build command](https://docs.github.com/en/code-security/code-scanning/automatically-scanning-your-code-for-vulnerabilities-and-errors/configuring-the-codeql-workflow-for-compiled-languages).\n\n"+secondLine,
		severityError, false,
		true, true, true,
		"", 0, 0, 0, 0,
	)
}

func EmitNewerGoVersionNeeded() {
	emitDiagnostic("go/autobuilder/newer-go-version-needed",
		"Newer Go version needed",
		"The detected version of Go is lower than the version specified in `go.mod`. [Install a newer version](https://github.com/actions/setup-go#basic).",
		severityError, false,
		true, true, true,
		"", 0, 0, 0, 0,
	)
}

func EmitGoFilesFoundButNotProcessed() {
	emitDiagnostic("go/autobuilder/go-files-found-but-not-processed",
		"Go files were found but not processed",
		"[Specify a custom build command](https://docs.github.com/en/github-ae@latest/code-security/code-scanning/automatically-scanning-your-code-for-vulnerabilities-and-errors/configuring-the-codeql-workflow-for-compiled-languages#adding-build-steps-for-a-compiled-language) that includes one or more `go build` commands to build the `.go` files to be analyzed.",
		severityError, false,
		true, true, true,
		"", 0, 0, 0, 0,
	)
}
