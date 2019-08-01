/*
 * Created by lzy on 2019-07-30 11:41.
 */
package com.lzy.demo.dubbo.client;

import com.lzy.demo.dubbo.api.SampleService;
import com.lzy.demo.dubbo.message.SampleRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 配置xml配置dubbo
 *
 * @author lzy
 * @version v1.0
 */
@ImportResource("classpath:client.xml")
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(ClientXMLTest.class)
public class ClientXMLTest {


    /**
     * 测试客户端
     *
     * @param sampleService the sample service
     */
    @Test
    public void testClient(@Autowired SampleService sampleService) {
        SampleRequest sampleRequest = new SampleRequest();
        sampleRequest.setRequest("request");
        System.out.println(sampleService.sampleService(sampleRequest));
    }

    /**
     * 测试校验
     *
     * @param sampleService the sample service
     */
    @Test
    public void testValidation(@Autowired SampleService sampleService) {
        System.out.println(sampleService.sampleService(new SampleRequest()));
    }
}
