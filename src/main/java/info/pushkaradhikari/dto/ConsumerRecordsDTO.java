package info.pushkaradhikari.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRecordsDTO {

	List<Map<String, String>> records = new ArrayList<>();

	public List<Map<String, String>> getData() {
		return records;
	}

	public void setData(List<Map<String, String>> data) {
		this.records = data;
	}
	
	public ConsumerRecordsDTO createFromConsumerRecords(ConsumerRecords<String, Map<String, String>> records) {
	
		for (ConsumerRecord<String, Map<String, String>> consumerRecord : records) {
			this.records.add(consumerRecord.value());
		}
		return this;
	}

}
