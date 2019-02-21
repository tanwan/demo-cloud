/*
 * Created by lzy on 2019-02-21 16:30.
 */
package com.lzy.demo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka服务端
 *
 * @author lzy
 * @version v1.0
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {


    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
