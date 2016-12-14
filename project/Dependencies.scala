import sbt._

object Dependencies {
  val AkkaHttpVersion = "10.0.0"
  lazy val akkaHttpCore     = "com.typesafe.akka"   %% "akka-http-core"       % AkkaHttpVersion
  lazy val akkaHttp         = "com.typesafe.akka"   %% "akka-http"            % AkkaHttpVersion
  lazy val akkaHttpTestKit  = "com.typesafe.akka"   %% "akka-http-testkit"    % AkkaHttpVersion
  lazy val akkaHttpPlayJson = "de.heikoseeberger"   %% "akka-http-play-json"  % "1.10.1"
  lazy val jsonSchema       = "com.sauldhernandez"  %% "autoschema"           % "1.0.3"
  lazy val scalaTest        = "org.scalatest"       %% "scalatest"            % "3.0.1" % Test
  lazy val mockito          = "org.mockito"          % "mockito-core"         % "2.2.29" % Test
}