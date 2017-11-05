import java.util
import java.util.Properties
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}

object ConsumerOffsetsDemo extends App{

  val properties = new Properties()
  properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
  properties.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaExampleConsumer")
  properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "10")
  properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer")
  properties.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer")

  val consumer = new KafkaConsumer[String, String](properties)

  consumer.subscribe(util.Arrays.asList("topic-1"))

  val recordsFromConsumer = consumer.poll(10000)
  val recordsFromConsumerList = recordsFromConsumer.asScala.toList

  val lastReadOffset = recordsFromConsumerList.last.offset()
  val partitionsAssigned = consumer.assignment()
  val endOffsetsPartitionMap = consumer.endOffsets(partitionsAssigned)

  val currentPosition = consumer.position(partitionsAssigned.toList.head)
  val consumerLag = endOffsetsPartitionMap.get(partitionsAssigned.head) - lastReadOffset
  println(s"Consumer Lag : ${consumerLag}")

}
