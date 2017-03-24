package com.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by user01 on 3/10/17.
 */

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServer {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "discovery-server");
        SpringApplication.run(DiscoveryServer.class, args);
    }
}
