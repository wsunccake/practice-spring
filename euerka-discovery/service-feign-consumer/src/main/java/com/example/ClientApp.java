package com.example;

import feign.Contract;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ClientApp {
    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);
    }
}


@Configuration
class FeignConfiguration {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}

@FeignClient(name = "service-provider")
interface ServiceProvider {

    @RequestLine("GET " + "/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home();
}

@RestController
class ClientController {
    @Autowired
    ServiceProvider serviceProvider;

    @RequestLine("GET " + "/")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        String body = serviceProvider.home();
        return "Feign Consumer get message: " + body;
    }
}
