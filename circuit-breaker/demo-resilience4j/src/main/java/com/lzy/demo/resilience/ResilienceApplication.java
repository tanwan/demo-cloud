/*
 * Created by lzy on 2020/4/1 5:42 PM.
 */
package com.lzy.demo.resilience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Circuit breaker application.
 *
 * @author lzy
 * @version v1.0
 */
@SpringBootApplication
public class ResilienceApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ResilienceApplication.class, args);
    }
}
