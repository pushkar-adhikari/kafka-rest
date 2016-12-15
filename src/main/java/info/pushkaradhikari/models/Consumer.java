package info.pushkaradhikari.models;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Configuration;

import info.pushkaradhikari.dto.ConsumerRecordsDTO;
import info.pushkaradhikari.utils.PropertiesLoader;

@Configuration
public class Consumer {
	
	Properties defaultProperties = PropertiesLoader.getConsumerProperties();
	
	private final KafkaConsumer<String, Map<String, String>> kConsumer;
	
	public Consumer() {
		this.kConsumer = new KafkaConsumer<String, Map<String, String>>(defaultProperties);
	}
	
	public Consumer setTopic(String... topic){
		this.kConsumer.subscribe(Arrays.asList(topic));
		return this;
	}
	
	public Consumer(String groupId, String... topic){
		defaultProperties.put("group.id", groupId);
		this.kConsumer = new KafkaConsumer<String, Map<String, String>>(defaultProperties);
		this.kConsumer.subscribe(Arrays.asList(topic));
	}
	
	public ConsumerRecordsDTO consume(){
		ConsumerRecordsDTO dto = new ConsumerRecordsDTO();
		return dto.createFromConsumerRecords(this.kConsumer.poll(1000));
	}
	
	public void stopConsumer(){
		this.kConsumer.close();
	}
	
}
