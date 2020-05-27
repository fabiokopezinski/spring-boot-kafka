package br.com.kafka.spring;

import org.apache.kafka.common.serialization.Serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializer<T> implements Serializer<T> {
	
	private final Gson json=new GsonBuilder().create();

	@Override
	public byte[] serialize(String topic, T data) {
		return json.toJson(data).getBytes();
	}
}