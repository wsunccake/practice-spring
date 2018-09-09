# Run Application

```bash
linux:~/hystrix-example # gradle wrapper
linux:~/hystrix-example # ./gradlew bootRun
```


# Test Web

```bash
linux:~ # curl http://localhost:8088/message
linux:~ # curl http://localhost:8088/message/1   # with hystrix and successful
linux:~ # curl http://localhost:8088/message/6   # with hystrix and failure
```


# Hystrix Dashboard

- http://localhost:8088/hystrix

- http://localhost:8088/actuator/hystrix.stream

