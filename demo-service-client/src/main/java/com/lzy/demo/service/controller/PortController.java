/*
 * Created by lzy on 2019-03-05 10:18.
 */
package com.lzy.demo.service.controller;

import com.lzy.demo.service.constant.Constants;
import com.lzy.demo.service.service.SampleFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 端口
 *
 * @author lzy
 * @version v1.0
 */
@RestController
public class PortController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private SampleFeignService sampleFeignService;

    /**
     * 使用ribbon获取端口
     *
     * @return the integer
     */
    @GetMapping("/ribbon/port")
    @HystrixCommand(fallbackMethod = "defaultRibbonGetPort")
    public Integer ribbonGetPort() {
        return restTemplate.getForObject(Constants.DEMO_SERVICE_SERVER + "/port", Integer.class);
    }


    /**
     * 使用ribbon获取端口
     *
     * @return the integer
     */
    @GetMapping("/feign/port")
    public Integer feignGetPort() {
        return sampleFeignService.serverPort();
    }

    /**
     * ribbon降级方法
     */
    private Integer defaultRibbonGetPort() {
        return 0;
    }
}
