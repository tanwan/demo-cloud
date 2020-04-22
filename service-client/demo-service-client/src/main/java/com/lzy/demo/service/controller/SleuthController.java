/*
 * Created by lzy on 2020/4/13 8:40 AM.
 */
package com.lzy.demo.service.controller;

import com.lzy.demo.service.constant.Constants;
import com.lzy.demo.service.service.BraveService;
import com.lzy.demo.service.service.SampleFeignService;
import com.lzy.demo.service.service.SleuthService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * sleuth controller
 *
 * @author lzy
 * @version v1.0
 */
@RestController
@RequestMapping("/sleuth")
public class SleuthController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private SampleFeignService sampleFeignService;

    @Resource
    private SleuthService sleuthService;

    @Resource
    private BraveService braveService;

    /**
     * 使用ribbon
     *
     * @return the string
     */
    @GetMapping("/ribbon")
    @HystrixCommand(fallbackMethod = "defaultRibbon")
    public String ribbon() {
        logger.info("sleuth ribbon");
        restTemplate.getForObject(Constants.DEMO_SERVICE_SERVER + "/sleuth2", String.class);
        return restTemplate.getForObject(Constants.DEMO_SERVICE_SERVER + "/sleuth", String.class);
    }


    /**
     * 使用feign
     *
     * @return the string
     */
    @GetMapping("/feign")
    public String feign() {
        logger.info("sleuth feign");
        sampleFeignService.sleuth2();
        return sampleFeignService.sleuth();
    }


    /**
     * 使用@Async
     */
    @GetMapping("/async")
    public String async() throws InterruptedException {
        logger.info("before controller async");
        sleuthService.async();
        logger.info("after controller async");
        return "success";
    }

    /**
     * 使用线程
     */
    @GetMapping("/thread")
    public String thread() throws InterruptedException {
        logger.info("before controller thread");
        sleuthService.thread();
        logger.info("after controller thread");
        return "success";
    }

    /**
     * 使用restTemplate
     */
    @GetMapping("/restTemplate")
    public String restTemplate() {
        logger.info("before controller restTemplate");
        sleuthService.restTemplate();
        logger.info("after controller restTemplate");
        return "success";
    }

    /**
     * 使用customizing
     */
    @GetMapping("/brave/customizing")
    public String customizing() {
        logger.info("before controller customizing");
        braveService.customizing();
        logger.info("after controller customizing");
        return "success";
    }


    /**
     * ribbon降级方法
     */
    private String defaultRibbon() {
        return "fallback";
    }
}
