package com.lightinginformationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LightingInformationApplication {
    public static void main(String[] args) {
        SpringApplication.run(LightingInformationApplication.class, args);
    }
}
