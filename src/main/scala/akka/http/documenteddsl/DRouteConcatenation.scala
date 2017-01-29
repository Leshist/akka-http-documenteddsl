package akka.http.documenteddsl

import akka.http.documenteddsl.directives.RouteDDirectives
import akka.http.documenteddsl.documentation.Documentation
import akka.http.scaladsl.server.{Route, RouteConcatenation}

import scala.language.implicitConversions

trait DRouteConcatenation {

  implicit def _enhanceRouteWithConcatenation(route: DRoute): DRouteConcatenation.DRouteWithConcatenation =
    new DRouteConcatenation.DRouteWithConcatenation(route: DRoute)

  def concat(routes: DRoute*): DRoute = routes.foldLeft[DRoute](RouteDDirectives.reject)(_ |~| _)

}

object DRouteConcatenation {

  class DRouteWithConcatenation(route: DRoute) {
    def |~|(other: DRoute): DRoute = {
      val concatenated = new RouteConcatenation.RouteWithConcatenation(route).~(other)
      new DRoute(concatenated) {
        override def describe(doc: Documentation): Documentation = {
          def write(route: Route, doc: Documentation): Documentation = route match {
            case x: DRoute => x.describe(doc)
            case _ => doc
          }

          val docWithOther = write(other, doc)
          write(route, docWithOther)
        }
      }
    }
  }

}