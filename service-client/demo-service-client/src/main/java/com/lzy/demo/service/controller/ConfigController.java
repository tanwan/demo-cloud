/*
 * Created by lzy on 2020/1/20 2:54 PM.
 */
package com.lzy.demo.service.controller;

import com.lzy.demo.service.bean.ConfigBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lzy
 * @version v1.0
 */
@RestController
public class ConfigController {

    @Resource
    private ConfigBean configBean;


    /**
     * 获取ConfigBean
     *
     * @return the integer
     */
    @GetMapping("/config/bean")
    public ConfigBean getConfigBean() {
        return configBean;
    }
}
