package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);
    }
}

@RestController
class ClientController {
    @Autowired
    RestTemplate restTemplate;

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStudents() {
        String body = restTemplate.getForEntity("http://service-provider", String.class).getBody();
//        String body = restTemplate.exchange("http://service-provider/", HttpMethod.GET, null, String.class).getBody();
        return "Ribbon Consumer get message: " + body;
    }

}


