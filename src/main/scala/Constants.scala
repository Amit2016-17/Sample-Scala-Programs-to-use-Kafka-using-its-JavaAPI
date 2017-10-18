import java.util.Properties

import org.apache.kafka.common.serialization.{Serde, Serdes, StringDeserializer, StringSerializer}
import org.apache.kafka.streams.StreamsConfig._//{APPLICATION_ID_CONFIG, BOOTSTRAP_SERVERS_CONFIG, DEFAULT_KEY_SERDE_CLASS_CONFIG, DEFAULT_VALUE_SERDE_CLASS_CONFIG}

object Constants{

  def getStreamConf = {
    val streamsConfiguration = new Properties()
    streamsConfiguration.put(APPLICATION_ID_CONFIG, "Streaming-QuickStart")
    streamsConfiguration.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    streamsConfiguration.put(KEY_SERDE_CLASS_CONFIG, Serdes.String.getClass.getName)
    streamsConfiguration.put(VALUE_SERDE_CLASS_CONFIG, Serdes.String.getClass.getName)
    streamsConfiguration
  }
  def getStreamConf1 = {
    val streamsConfiguration = new Properties()
    streamsConfiguration.put(APPLICATION_ID_CONFIG, "Streaming-QuickStart1")
    streamsConfiguration.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
    streamsConfiguration.put(KEY_SERDE_CLASS_CONFIG, Serdes.String.getClass.getName)
    streamsConfiguration.put(VALUE_SERDE_CLASS_CONFIG, Serdes.String.getClass.getName)
    streamsConfiguration
  }

  val stringSer = new StringSerializer
  val stringDe = new StringDeserializer
  val stringSerde: Serde[String] = Serdes.String()
  val firstInTopic = "topic-1"
  val secondInTopic = "topic-2"
  val thirdInTopic = "topic-3"
  val firstOutTopic = "topic-out-1"
  val secondOutTopic = "topic-out-2"
  val thirdOutTopic = "topic-out-3"

}