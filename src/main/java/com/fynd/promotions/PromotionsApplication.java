package com.fynd.promotions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.fynd.promotions.services.DataService;

@SpringBootApplication
@EnableScheduling
public class PromotionsApplication implements CommandLineRunner{
	
	@Autowired
	private DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(PromotionsApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
	
		dataService.getData();
		
	}

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
