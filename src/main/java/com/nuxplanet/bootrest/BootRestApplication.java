package com.nuxplanet.bootrest;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootRestApplication.class, args);
    }
    
}
