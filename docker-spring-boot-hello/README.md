# Run Application

```bash
linux:~/docker-spring-boot-hello # ./gradlew bootRun
linux:~/docker-spring-boot-hello # ./gradlew bootRun -Dspring.output.ansi.enabled=always
```


# Test Case

```bash
linux:~/docker-spring-boot-hello # ./gradlew clean test
```


# Build Docker Image

```bash
linux:~/docker-spring-boot-hello # ./gradlew docker
```

# Test Web

```bash
linux:~ # curl http://127.0.0.1
linux:~ # curl http://127.0.0.1/hello/spring
linux:~ # curl http://127.0.0.1/nice?name=spring
```
