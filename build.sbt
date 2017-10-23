////////////////////////////////////////////////////////////////////////////////
// artifact
////////////////////////////////////////////////////////////////////////////////
name := "persianutils"
version := "2.1-SNAPSHOT"
description := "A collection of utilities for Scala/Java developers who are targeting Persian (Farsi) speaking users."
homepage := Some(url("https://github.com/bahmanm/persianutils"))
licenses += "Apache 2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt")
organization := "com.bahmanm"
organizationHomepage := Some(url("http://BahmanM.com"))

////////////////////////////////////////////////////////////////////////////////
// build
////////////////////////////////////////////////////////////////////////////////
scalaVersion := "2.10.6"
libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.11" % "test"
)
resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)
scalacOptions in Test ++= Seq("-Yrangepos")
crossScalaVersions := Seq("2.10.6", "2.11.11")

////////////////////////////////////////////////////////////////////////////////
// sonatype and maven central
////////////////////////////////////////////////////////////////////////////////
useGpg := true
publishMavenStyle := true
pomIncludeRepository := { _ => false }
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
scmInfo := Some(
  ScmInfo(
    url("https://github.com/bahmanm/persianutils"),
    "scm:git@github.com:bahmanm/persianutils.git"
  )
)
developers := List(
  Developer(
    id    = "bahmanm",
    name  = "Bahman Movaqar",
    email = "Bahman@BahmanM.com",
    url   = url("http://BahmanM.com")
  ),
  Developer(
    id    = "amirkarimi",
    name  = "Amir Karimi",
    email = "na@na.com",
    url   = url("http://amirkarimi.github.io/")
  )
)
