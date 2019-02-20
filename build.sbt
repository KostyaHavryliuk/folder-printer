name := "FolderPrinter"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= {
  val akkaVersion = "2.5.12"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "org.scalatest" %% "scalatest" % "3.0.5" % "test"
  )
}