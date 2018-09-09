package com.example.circuitbreaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class CircuitBreakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircuitBreakerApplication.class, args);
    }


    @RestController
    class MessageRestController {

        @Value("${circuit-breaker.message:Hello Hystrix}")
        private String message;

        @RequestMapping(path = "/message")
        String getMessage() {
            return this.message;
        }

        @RequestMapping(path = "/message/{time}")
        @HystrixCommand(fallbackMethod = "getDefaultMessage",
                commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")}
                )
        String getMessage(@PathVariable("time") int time) {
            try {
                Thread.sleep(time * 1000);
            }
            catch (Exception e) {
                System.out.println("Got an exception!");
            }

            return this.message;
        }

        String getDefaultMessage(int time) {
            return "out-of-service";
        }
    }
}
