name := "spark_app"

version := "0.1"

scalaVersion := "2.10.6"

val sparkVersion = "2.2.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
  //"org.apache.spark" %% "spark-streaming" % sparkVersion,
  //"org.apache.spark" %% "spark-streaming-twitter" % sparkVersion
)
        