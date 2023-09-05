package com.demo.employeservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.demo.employeservice.model.SwipeSummaryKafkaProducerModel;

@Configuration
public class KafkaConfig {
	
	@Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;
	
	@Bean
	public ProducerFactory<String, SwipeSummaryKafkaProducerModel> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory(config);
	}

	@Bean
	public KafkaTemplate<String, SwipeSummaryKafkaProducerModel> kafkaTemplate() {
		return new KafkaTemplate<String, SwipeSummaryKafkaProducerModel>(producerFactory());
	}
}
