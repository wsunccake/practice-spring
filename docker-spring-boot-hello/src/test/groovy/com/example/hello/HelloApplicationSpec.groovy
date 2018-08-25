package com.example

import com.example.hello.HelloApplication
import com.example.hello.TestConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.annotation.Import
import org.springframework.http.HttpStatus
import spock.lang.Shared
import spock.lang.Specification


@SpringBootTest(classes = HelloApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestConfig)
class HelloApplicationSpec extends Specification{

    @Shared
    @LocalServerPort
    int port

    @Autowired
    TestRestTemplate restTemplate

    def 'default page'() {
        when:
        "http://127.0.0.1:${port}"
        def entity = restTemplate.getForEntity("/", String.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body == "Hello Spring Boot!"
    }

    def 'say hello page'() {
        when:
        def entity = restTemplate.getForEntity("/hello/Spring", String.class)

        then:
        entity.statusCode == HttpStatus.OK
        entity.body == "Hello Spring !"
    }

    def 'say nice page'() {
        expect:
        restTemplate.getForEntity("/nice?name=Spring", String.class).body == "Nice to meet Spring !"
    }
}
