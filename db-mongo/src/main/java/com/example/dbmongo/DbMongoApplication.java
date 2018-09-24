package com.example.dbmongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DbMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbMongoApplication.class, args);
    }

    @RestController
    class MessageRestController {

        @Value("${message:Hello Default}")
        private String message;

        // return string
        @RequestMapping("/hello")
        String getHello() {
            return this.message;
        }

        // return json
        @RequestMapping("/hi")
        Map<String, String> getHi() {
            HashMap<String, String> map = new HashMap<>();
            map.put("Hi", "Spring Boot");
            return map;
        }
    }
}
