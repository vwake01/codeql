// generated by codegen/codegen.py
import codeql.swift.elements.expr.AnyTryExpr

class TryExprBase extends @try_expr, AnyTryExpr {
  override string getAPrimaryQlClass() { result = "TryExpr" }
}
