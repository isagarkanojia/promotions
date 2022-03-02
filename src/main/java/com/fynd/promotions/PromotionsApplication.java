package com.fynd.promotions;

import com.fynd.promotions.services.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class PromotionsApplication implements CommandLineRunner {

    @Autowired
    private DataService dataService;

    public static void main(String[] args) {
        SpringApplication.run(PromotionsApplication.class, args);

    }

    @Override
    public void run(String... args) {
        try {
            dataService.getData();
        } catch (Exception e) {
            log.error("Not able to fetch data from third party API", e);
        }

    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
