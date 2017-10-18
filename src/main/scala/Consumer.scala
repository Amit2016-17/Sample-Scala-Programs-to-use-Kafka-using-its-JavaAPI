import java.util
import java.util.Properties

import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import scala.collection.JavaConversions._
import org.apache.kafka.common.requests.MetadataResponse.TopicMetadata
import org.apache.kafka.common.requests.MetadataRequest.allTopics
import org.apache.kafka.common.requests.MetadataRequest._
import org.codehaus.jackson.map.deser.std.StringDeserializer

object Consumer extends App{

  val properties = new Properties()
  properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  properties.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaExampleConsumer")
  properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "5")
  properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")

  val consumer = new KafkaConsumer[String, String](properties)
  val consumer2 = new KafkaConsumer[String, String](properties)

  consumer.subscribe(util.Arrays.asList("topic-1"))
//  consumer.beginningOffsets()
  val topicPartition = consumer.assignment()
  val records = consumer.poll(60000)
  consumer.commitSync()
  val count = records.count()
  println("count : " + count)
  val iterator = records.iterator()
  while(iterator.hasNext){
    val consumerRecord = iterator.next()
    println("Key: " + consumerRecord.key() + " offset: " + consumerRecord.offset() +
    " partition: " + consumerRecord.partition()  + " value: "+ consumerRecord.value())
  }
  println("Empty : ")
  println(records.isEmpty)

  Thread.sleep(10000)

  val recordsList = records.records("topic-1").toList
  val lastOffset = recordsList.get(recordsList.size - 1).offset()


}

class TopicOffsetSample {

  val topics = List("topic-1")
//  val metadata = new TopicMetadataRequest


}
