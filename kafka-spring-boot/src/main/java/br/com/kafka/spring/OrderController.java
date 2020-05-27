package br.com.kafka.spring;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private KafkaProducerService<Order> orderProducer;

	@GetMapping
	public String send() {
		var userId = UUID.randomUUID().toString();
        var orderId = UUID.randomUUID().toString();
        var amount = new BigDecimal(Math.random() * 5000 + 1);
		var order = new Order(userId, orderId, amount);
		orderProducer.send(order, "ECOMMERCE_NEW_ORDER");
		return "Foi";
	}
}
