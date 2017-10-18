import java.util.Properties

import akka.actor.ActorSystem
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by simar on 18/10/17.
  */
object GeneratorApp extends App {

  val properties = new Properties()
  properties.put("bootstrap.servers", "localhost:9092")
  properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[String, String](properties)

  var ctr = 1
  val system = ActorSystem("system")
  system.scheduler.schedule(0 second, 2 seconds){
    val record1 = new ProducerRecord[String, String](Constants.firstInTopic, ctr.toString, "data from topic1 "+ctr)
    val record2 = new ProducerRecord[String, String](Constants.secondInTopic, ctr.toString, "data from topic2 "+ctr)
    val record3 = new ProducerRecord[String, String](Constants.thirdInTopic, ctr.toString, "data from topic3 "+ctr)
    ctr += 1
    producer.send(record1)
    producer.send(record2)
    producer.send(record3)
  }


}
