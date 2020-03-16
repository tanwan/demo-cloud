/*
 * Created by lzy on 2019-07-30 11:24.
 */
package com.lzy.demo.dubbo.server;

import com.lzy.demo.dubbo.api.SampleService;
import com.lzy.demo.dubbo.message.SampleRequest;
import com.lzy.demo.dubbo.message.SampleResponse;

/**
 * 服务提供者 org.apache.dubbo.config.annotation.Service注解的属性同dubbo:service
 *
 * @author lzy
 * @version v1.0
 */
@org.apache.dubbo.config.annotation.Service
public class SampleServiceDubbompl implements SampleService {
    @Override
    public SampleResponse sampleService(SampleRequest request) {
        System.out.println(request);
        SampleResponse sampleResponse = new SampleResponse();
        sampleResponse.setResponse("hello world");
        return sampleResponse;
    }
}
