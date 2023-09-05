package com.demo.attendenceservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AttendenceReportKafkaConsumer {
	@KafkaListener(topics = "test", groupId = "group_id")
	public void consume(String message) {
		// Print statement
		System.out.println("message = " + message);
	}
}
