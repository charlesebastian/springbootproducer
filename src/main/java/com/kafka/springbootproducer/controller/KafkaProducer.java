package com.kafka.springbootproducer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.springbootproducer.entity.Customer;

@RequiredArgsConstructor
@Component
@RestController
public class KafkaProducer {

	private final KafkaTemplate<String, Customer> template;

	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		template.send("CustomerTopic",customer);
		return "Producer has published the topic";
	}
}
