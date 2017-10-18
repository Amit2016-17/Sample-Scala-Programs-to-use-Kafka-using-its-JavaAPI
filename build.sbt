name := "KafkaConsumerOffsetsUsage"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.2.0",
  "org.apache.spark" %% "spark-sql" % "2.2.0",
  "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.2.0",
  "org.apache.kafka" % "kafka-streams" % "0.10.2.1" exclude("com.fasterxml.jackson.core", "jackson-databind"),
  "com.typesafe.akka" %% "akka-actor" % "2.5.2"
)
        