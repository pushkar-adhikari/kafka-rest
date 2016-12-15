package info.pushkaradhikari.models;

import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.context.annotation.Configuration;

import info.pushkaradhikari.dto.ProducerRecordDTO;
import info.pushkaradhikari.utils.PropertiesLoader;

@Configuration
public class Producer {

	Properties defaultProperties = PropertiesLoader.getProducerProperties();

	private final KafkaProducer<String, Map<String, String>> kProducer;
	private final String topic;

	public Producer() {
		this.kProducer = new KafkaProducer<String, Map<String, String>>(defaultProperties);
		this.topic = null;
	}

	public Producer(String topic) {
		this.kProducer = new KafkaProducer<String, Map<String, String>>(defaultProperties);
		this.topic = topic;
	}

	public Producer(String topic, Properties otherProperties) {
		this.defaultProperties.putAll(otherProperties);
		this.kProducer = new KafkaProducer<String, Map<String, String>>(defaultProperties);
		this.topic = topic;
	}

	public void produceMessage(ProducerRecordDTO data) {

		kProducer.send(new ProducerRecord<String, Map<String, String>>(topic, data.getData()), new Callback() {
			@Override
			public void onCompletion(RecordMetadata metadata, Exception e) {
				if (e != null) {
					e.printStackTrace();
					Logger.getGlobal().log(Level.SEVERE,
							"Exception: Partition: " + metadata.partition() + ", Offset: " + metadata.offset());
				} else {
					Logger.getGlobal().log(Level.INFO,
							"Sent: Partition: " + metadata.partition() + ", Offset: " + metadata.offset());
				}
			}
		});

	}

	public void stopProducer() {
		this.kProducer.close();
	}

}
