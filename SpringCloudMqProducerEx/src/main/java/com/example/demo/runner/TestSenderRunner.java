package com.example.demo.runner;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;	
import com.example.demo.service.ProducerService;

@Component
public class TestSenderRunner {
//implements CommandLineRunner{

	@Autowired
	private ProducerService service;
	
	// \bin\windows\kafka-topics.bat --create --topic myabc --bootstrap-server localhost:9092
	// \bin\windows\kafka-console-producer.bat --topic myabc --bootstrap-server localhost:9092
	// Kafka-console-consumer.bat --topic myabc --from-beginning --bootstrap-server localhost:9092   
	// Kafka-console-consumer.bat --topic myabc --from-beginning --bootstrap-server localhost:9092   
	
//	public void run(String... args) throws Exception {

	@Scheduled(cron = "*/10 * * * * *")
	public void sendMsgTest() throws Exception {
		service.sendMessage("Hello " + new Date());
	}

}
