package com.demo.attendenceservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.demo.attendenceservice.model.SwipeSummaryKafkaProducerModel;


@Configuration
@EnableKafka
public class KafkaConfig {

	@Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;
	
	@Value(value = "${spring.kafka.attendance-consumer-group}")
    private String attendenceReportGroupId;
	
	 public ConsumerFactory<String, SwipeSummaryKafkaProducerModel> consumerFactory()
	    {
		 Map<String, Object> config = new HashMap<>();
			config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
			config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
			config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	        config.put(ConsumerConfig.GROUP_ID_CONFIG,
	        		attendenceReportGroupId);
	        return new DefaultKafkaConsumerFactory<>(config);
	    }
	  
	    // Creating a Listener
	    public ConcurrentKafkaListenerContainerFactory
	    concurrentKafkaListenerContainerFactory()
	    {
	        ConcurrentKafkaListenerContainerFactory<
	            String, SwipeSummaryKafkaProducerModel> factory
	            = new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
}
