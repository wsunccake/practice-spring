# MySQL Setup

```mysql
-- create database
mysql> create database db_example;
mysql> show databases;


-- create user
mysql> create user 'springuser'@'localhost' identified by 'ThePassword';
mysql> select Host, User from mysql.user;


-- give all the privileges to the new user on created database
mysql> grant all on db_example.* to 'springuser'@'localhost';
mysql> show grants for springuser@localhost;


-- remote user
mysql> create user 'springuser'@'%' identified by 'ThePassword';
mysql> grant all on db_example.* to 'springuser'@'%';
```


# Run Application

```bash
linux:~/db-mysql # gradle wrapper
linux:~/db-mysql # ./gradlew bootRun
```


# Test Web

```bash
linux:~ # curl 'http://localhost:8080/demo/add?name=One&email=one@demo.com'
linux:~ # curl http://localhost:8080/demo/all
```
