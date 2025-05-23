package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

	@Autowired
	private JmsTemplate jt;

	@Value("${my.app.deti-name}")
	private String destination;

	public void sendMessage(String message) {
		jt.send(destination, session -> session.createTextMessage(message));
		System.out.println("MESSAGE SENT BY PRODUCER " + message);
	}

}
