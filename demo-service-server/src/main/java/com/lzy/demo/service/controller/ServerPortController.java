/*
 * Created by lzy on 2019-02-25 09:01.
 */
package com.lzy.demo.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 从demo-service-client获取端口
 *
 * @author lzy
 * @version v1.0
 */
@RestController
public class ServerPortController {
    private static final String DEMO_SERVICE_CLIENT = "demo-service-client";
    @Resource
    private RestTemplate restTemplate;

    /**
     * 从demo-service-client获取端口
     *
     * @return the integer
     */
    @GetMapping("/port")
    public Integer serverPort() {
        return restTemplate.getForObject("http://" + DEMO_SERVICE_CLIENT + "/port", Integer.class);
    }
}
