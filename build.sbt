name := "confluent-spark-avro"

version := "1.2.2"

scalaVersion := "2.11.11"

resolvers += "confluent" at "http://packages.confluent.io/maven/"


libraryDependencies ++= Seq(
    "org.apache.spark" % "spark-streaming-kafka-0-10_2.11" % "2.3.0",
    "org.apache.spark" % "spark-sql_2.11" % "2.3.0" % "provided",
    "org.apache.spark" % "spark-sql-kafka-0-10_2.11" % "2.3.0",
    "org.apache.kafka" %% "kafka" % "0.10.1.1" % "provided",
    "com.amazonaws" % "aws-java-sdk-kms" % "1.10.75.1",
    "io.confluent" % "kafka-avro-serializer" % "3.2.2",
    "com.databricks" %% "spark-avro" % "3.2.0",
    "org.scalaz" % "scalaz-core_2.11" % "7.3.0-M14"
)

// Include provided dependencies when "sbt run" is called.
run in Compile := Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))

assemblyMergeStrategy in assembly := {
 case PathList("META-INF", xs @ _*) => MergeStrategy.discard
 case x => MergeStrategy.first
}
