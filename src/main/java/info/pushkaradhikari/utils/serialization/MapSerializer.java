package info.pushkaradhikari.utils.serialization;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

public interface MapSerializer<K, V> extends Serializer<Map<K, V>> {

}
