package info.pushkaradhikari.utils.serialization;

import java.util.Map;

import org.springframework.util.SerializationUtils;

public class HashMapSerializer<K, V> implements MapSerializer<K, V> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// nothing to do
	}

	@Override
	public byte[] serialize(String topic, Map<K, V> data) {
		return SerializationUtils.serialize(data);
	}

	@Override
	public void close() {
		// nothing to do
	}

}
