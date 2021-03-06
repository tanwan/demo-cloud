/*
 * Created by lzy on 2019-02-21 18:46.
 */
package com.lzy.demo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 微服务提供方
 *
 * @author lzy
 * @version v1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class ServerApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
