package br.com.kafka.spring;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {

	private final String userId;
	private final String orderId;
	private final BigDecimal amount;
}
