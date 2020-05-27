package br.com.kafka.spring;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter	
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserConsumer{
	
	private String nome;
	private String sobrenome;

}
