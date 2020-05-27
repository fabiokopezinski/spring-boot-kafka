package br.com.kafka.spring;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumerService {
	
	@KafkaListener(topics ="ECOMMERCE_NEW_ORDER", groupId = "group_id")
	 public void consumer(ConsumerRecord<String, Order> consumerRecord) {
		log.info("key: " + consumerRecord.key());
		log.info("value: " + consumerRecord.value());
        log.info("Partion: " + consumerRecord.partition());
        log.info("Orders: " + consumerRecord.offset());
            
    }
}
