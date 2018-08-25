package com.example.hello.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {

//    @Value("${name:Spring}")
//    private String name;

    public String sayHello(String name) {
        return String.format("Hello %s !", name);
    }

    public String sayNice(String name) {
        return String.format("Nice to meet %s !", name);
    }
}
