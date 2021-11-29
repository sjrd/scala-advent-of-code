ThisBuild / scalaVersion := "3.1.0"

lazy val solver = project
  .in(file("solver"))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.0.0",
      "com.raquo" %%% "laminar" % "0.14.2"
    ),
    scalaJSUseMainModuleInitializer := true
  )

lazy val docs = project
  .in(file("myproject-docs"))
  .enablePlugins(MdocPlugin, DocusaurusPlugin)
