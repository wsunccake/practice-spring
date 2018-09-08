# Run Application

```bash
linux:~/config-client # gradle wrapper
linux:~/config-client # ./gradlew bootRun
linux:~/config-client # ./gradlew bootRun -Dspring.profiles.active=dev
```


# Test Web

```bash
linux:~ # curl http://localhost:8899/message   # for dev
linux:~ # curl http://localhost:8811/message   # for prd
```
