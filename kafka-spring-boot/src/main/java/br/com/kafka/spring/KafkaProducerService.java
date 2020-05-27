package br.com.kafka.spring;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService<T> {

	@Autowired
	private KafkaTemplate<String, T> kafkaTemplate;

	public void send(T message, String topic) {
		kafkaTemplate.send(topic, UUID.randomUUID().toString(), message);
	}
}
