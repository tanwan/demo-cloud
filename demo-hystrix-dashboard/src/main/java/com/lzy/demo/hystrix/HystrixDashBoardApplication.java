/*
 * Created by lzy on 2019-03-04 17:40.
 */
package com.lzy.demo.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * hystrix dashboard
 *
 * @author lzy
 * @version v1.0
 */
@EnableDiscoveryClient
//开启HystrixDashboard
@EnableHystrixDashboard
@EnableTurbine
@SpringBootApplication
public class HystrixDashBoardApplication {
    /**
     * main函数
     *
     * @param args the input arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(HystrixDashBoardApplication.class, args);
    }
}
