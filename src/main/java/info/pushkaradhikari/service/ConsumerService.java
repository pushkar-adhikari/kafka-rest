package info.pushkaradhikari.service;

import org.springframework.stereotype.Service;

import info.pushkaradhikari.dto.ConsumerRecordsDTO;
import info.pushkaradhikari.models.Consumer;

@Service
public class ConsumerService {

	public static ConsumerRecordsDTO consume(String groupId, String... topic) {
		Consumer consumer = new Consumer(groupId, topic);
		ConsumerRecordsDTO records = consumer.consume();
		consumer.stopConsumer();
		return records;
	}

}
