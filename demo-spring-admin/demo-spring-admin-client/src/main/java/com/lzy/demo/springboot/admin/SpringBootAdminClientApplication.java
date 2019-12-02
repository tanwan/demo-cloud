/*
 * Created by lzy on 2019/11/5 4:48 PM.
 */
package com.lzy.demo.springboot.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Spring boot admin server application.
 *
 * @author lzy
 * @version v1.0
 */
@SpringBootApplication
public class SpringBootAdminClientApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClientApplication.class, args);
    }
}
