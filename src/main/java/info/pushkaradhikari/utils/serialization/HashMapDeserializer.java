package info.pushkaradhikari.utils.serialization;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.SerializationUtils;

public class HashMapDeserializer<K, V> implements MapDeserializer<K, V> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// nothing to do
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<K, V> deserialize(String topic, byte[] data) {
		return (HashMap<K, V>) SerializationUtils.deserialize(data);
	}

	@Override
	public void close() {
		// nothing to do
	}

}
