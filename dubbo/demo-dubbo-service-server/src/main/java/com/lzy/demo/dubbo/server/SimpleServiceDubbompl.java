/*
 * Created by lzy on 2019-07-30 11:24.
 */
package com.lzy.demo.dubbo.server;

import com.lzy.demo.dubbo.api.SimpleService;
import com.lzy.demo.dubbo.message.SimpleRequest;
import com.lzy.demo.dubbo.message.SimpleResponse;

/**
 * 服务提供者 org.apache.dubbo.config.annotation.Service注解的属性同dubbo:service
 *
 * @author lzy
 * @version v1.0
 */
@org.apache.dubbo.config.annotation.Service
public class SimpleServiceDubbompl implements SimpleService {
    @Override
    public SimpleResponse simpleService(SimpleRequest request) {
        System.out.println(request);
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setResponse("hello world");
        return simpleResponse;
    }
}
