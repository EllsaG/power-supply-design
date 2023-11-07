package com.project.compensationdevice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CompensationDeviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompensationDeviceApplication.class, args);
    }
}
