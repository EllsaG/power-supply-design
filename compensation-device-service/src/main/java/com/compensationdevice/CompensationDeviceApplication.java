package com.compensationdevice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompensationDeviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompensationDeviceApplication.class, args);
    }
}
