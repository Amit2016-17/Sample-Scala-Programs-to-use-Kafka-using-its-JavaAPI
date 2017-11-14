# Sample-Scala-Programs-to-use-Kafka-using-its-JavaAPI

This repository includes scala examples on using kafka. This project contains multiple main clases- one of them is 
GeneratorApp which acts as Producer as it sends data to Kafka topic. Rest of them are consumers for different use cases.

You can clone this project to your system using
#### git clone https://github.com/ksimar/Sample-Scala-Programs-to-use-Kafka-using-its-JavaAPI.git
and to run the code, type
#### sbt run
from the terminal at the project location. 

It will ask for the main class which you want to start. 
First select GeneratorApp to send data to Kafka topic. Because only then you would be able to consume from that topic. Otherwise,
if you try to consume first before sending data to Kafka topic, you will not consume anything. Once you start producing data to topic, it becomes available for consumption.

If GeneratorApp is started successfully, you can start any consumer main class by following same procedure. i.e sbt run
and type class number for ypur consumer class.
