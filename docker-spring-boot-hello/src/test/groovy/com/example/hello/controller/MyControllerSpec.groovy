package com.example.hello.controller

import com.example.hello.TestConfig
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import(TestConfig)
class MyControllerSpec extends Specification{

    def 'controller - home'() {
        expect:
        new MyController().home() == "Hello Spring Boot!"
    }
}
