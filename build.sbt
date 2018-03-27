import Dependencies._
lazy val sparkVersion = "2.3.0"
lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.codemobile.example",
      scalaVersion := "2.11.12",
      version      := "0.1.0"
    )),
    name := "apache-spark-seed",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion,
      "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided",
      "org.apache.spark" %% "spark-mllib" % sparkVersion,
      "org.apache.spark" %% "spark-sql" % sparkVersion,
      "org.scalatest" %% "scalatest" % "3.0.4" % Test
   )
)
