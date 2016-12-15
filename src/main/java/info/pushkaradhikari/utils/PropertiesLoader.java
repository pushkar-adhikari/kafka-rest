package info.pushkaradhikari.utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesLoader extends Properties{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6475966730857115069L;

	public static Properties getProducerProperties() {
		Properties properties = new Properties();
		try {
			properties.load(ClassLoader.getSystemResourceAsStream("kafka/producer.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public static Properties getConsumerProperties() {
		Properties properties = new Properties();
		try {
			properties.load(ClassLoader.getSystemResourceAsStream("kafka/consumer.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
}
