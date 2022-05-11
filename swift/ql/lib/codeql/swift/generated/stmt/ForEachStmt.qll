// generated by codegen/codegen.py
import codeql.swift.elements.stmt.BraceStmt
import codeql.swift.elements.expr.Expr
import codeql.swift.elements.stmt.LabeledStmt

class ForEachStmtBase extends @for_each_stmt, LabeledStmt {
  override string getAPrimaryQlClass() { result = "ForEachStmt" }

  BraceStmt getBody() {
    exists(BraceStmt x |
      for_each_stmts(this, x, _) and
      result = x.resolve()
    )
  }

  Expr getSequence() {
    exists(Expr x |
      for_each_stmts(this, _, x) and
      result = x.resolve()
    )
  }

  Expr getWhere() {
    exists(Expr x |
      for_each_stmt_wheres(this, x) and
      result = x.resolve()
    )
  }

  predicate hasWhere() { exists(getWhere()) }
}
