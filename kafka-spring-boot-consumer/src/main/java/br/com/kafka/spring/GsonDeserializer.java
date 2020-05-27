package br.com.kafka.spring;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class GsonDeserializer<T> implements Deserializer<T> {

    public static final String TYPE_CONFIG = "br.com.alura.kafka.spring.type_config";
    private Class<T> type;
	private Gson json= new GsonBuilder().create();
	
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
        String typeName = String.valueOf(configs.get(TYPE_CONFIG));
        try {
            this.type = (Class<T>) Class.forName(typeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Type for deserialization does not exist in the classpath." ,e);
        }
    }
		
	@Override
	public T deserialize(String topic, byte[] data) {
		return  json.fromJson(new String(data),type);
	}
	
}
