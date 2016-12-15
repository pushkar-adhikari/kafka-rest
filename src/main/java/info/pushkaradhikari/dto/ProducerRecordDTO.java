package info.pushkaradhikari.dto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ProducerRecordDTO {

	private Map<String, String> data = new HashMap<String, String>();

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public ProducerRecordDTO(Map<String, String> data) {
		this.data = data;
	}

	public ProducerRecordDTO() {
		this.data = Collections.emptyMap();
	}

}
