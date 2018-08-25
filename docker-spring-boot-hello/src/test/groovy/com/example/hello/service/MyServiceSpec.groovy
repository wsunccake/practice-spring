package com.example.hello.service

import com.example.hello.TestConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import(TestConfig)
class MyServiceSpec extends Specification {

    @Autowired
    MyService service

    def 'say hello'() {
        expect:
        service.sayHello(name) == sentence

        where:
        name    | sentence
        "Spring"| "Hello Spring !"
        "Spock" | "Hello Spock !"
    }

    def 'say nice'() {
        when:
        def words = service.sayNice(name)

        then:
        words == sentence

        where:
        name    | sentence
        "Spring"| "Nice to meet Spring !"
        "Spock" | "Nice to meet Spock !"
    }
}
