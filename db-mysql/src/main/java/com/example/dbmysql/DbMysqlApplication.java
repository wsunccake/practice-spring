package com.example.dbmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DbMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbMysqlApplication.class, args);
    }
}
