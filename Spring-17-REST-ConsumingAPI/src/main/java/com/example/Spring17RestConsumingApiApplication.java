package com.example;

import com.example.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Spring17RestConsumingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring17RestConsumingApiApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
