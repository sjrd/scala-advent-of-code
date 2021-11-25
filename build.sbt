ThisBuild / scalaVersion := "3.1.0"

lazy val jsdocs = project
  .settings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.0.0"
  )
  .enablePlugins(ScalaJSPlugin)

lazy val docs = project
  .in(file("myproject-docs"))
  .settings(
    mdocJS := Some(jsdocs),
  )
  .dependsOn(jsdocs)
  .enablePlugins(MdocPlugin, DocusaurusPlugin)

