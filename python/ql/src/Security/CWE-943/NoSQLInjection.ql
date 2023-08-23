/**
 * @name NoSQL Injection
 * @description Building a NoSQL query from user-controlled sources is vulnerable to insertion of
 *              malicious NoSQL code by the user.
 * @kind path-problem
 * @problem.severity error
 * @id py/nosql-injection
 * @tags security
 *       experimental
 *       external/cwe/cwe-943
 */

import python
import semmle.python.security.dataflow.NoSQLInjectionQuery
import Flow::PathGraph

from Flow::PathNode source, Flow::PathNode sink
where Flow::flowPath(source, sink)
select sink.getNode(), source, sink, "This NoSQL query contains an unsanitized $@.", source,
  "user-provided value"
