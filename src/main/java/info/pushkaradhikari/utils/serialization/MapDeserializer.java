package info.pushkaradhikari.utils.serialization;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

public interface MapDeserializer<K, V> extends Deserializer<Map<K, V>> {

}
