package com.example.webservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }

    @RestController
    class MessageController {
        @Value("${message:Hello API}")
        private String message;

        @RequestMapping(path = "/")
        String home() {
            return this.message;
        }

        @RequestMapping(path = "/hi/{name}")
        String hi(@PathVariable("name") String name) {
            return String.format("Hi %s", name);
        }
    }

}
