package com.kafka.springbootproducer.controller;

import com.kafka.springbootproducer.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class KafkaProducer {

	private final KafkaTemplate<String, Customers> template;
	@Autowired
	public KafkaProducer(KafkaTemplate<String, Customers> kafkaTemplate) {
		this.template = kafkaTemplate;
	}

	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customers customer) {
		template.send("CustomerTopic",customer);
		return "Producer has published the topic";

	}

}
