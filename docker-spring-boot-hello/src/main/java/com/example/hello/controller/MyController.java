package com.example.hello.controller;

import com.example.hello.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @Autowired
    MyService service;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello Spring Boot!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable("name") String name) {
        return service.sayHello(name);
    }

    @RequestMapping(value = "/nice")
    public String sayNice(@RequestParam(value="name", required=false, defaultValue = "Spring") String name) {
        return service.sayNice(name);
    }
}
