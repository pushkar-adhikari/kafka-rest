package info.pushkaradhikari.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.pushkaradhikari.dto.ConsumerRecordsDTO;
import info.pushkaradhikari.dto.ProducerRecordDTO;
import info.pushkaradhikari.models.RestResponse;
import info.pushkaradhikari.service.ConsumerService;
import info.pushkaradhikari.service.ProducerService;

@RestController
@RequestMapping(value = "/kafka/topic")
public class KafkaController {

	@PostMapping(value = "/{topic}", consumes = "application/json")
	@ResponseBody
	public RestResponse produce(@PathVariable String topic, @RequestBody HashMap<String, String> data) {
		ProducerService.produce(topic, new ProducerRecordDTO(data));
		return new RestResponse("Success");
	}

	@GetMapping(value = "/{topic}/{id}")
	@ResponseBody
	public ConsumerRecordsDTO consume(@PathVariable String id, @PathVariable String topic) {
		return ConsumerService.consume(id, topic);
	}

}