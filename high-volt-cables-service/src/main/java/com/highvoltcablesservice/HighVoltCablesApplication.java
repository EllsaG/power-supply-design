package com.highvoltcablesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HighVoltCablesApplication {
    public static void main(String[] args) {
        SpringApplication.run(HighVoltCablesApplication.class, args);
    }
}
