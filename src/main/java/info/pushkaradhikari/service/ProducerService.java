package info.pushkaradhikari.service;

import org.springframework.stereotype.Service;

import info.pushkaradhikari.dto.ProducerRecordDTO;
import info.pushkaradhikari.models.Producer;

@Service
public class ProducerService {

	public static void produce(String topic, ProducerRecordDTO data) {
		Producer producer = new Producer(topic);
		producer.produceMessage(data);
		producer.stopProducer();
	}

}
