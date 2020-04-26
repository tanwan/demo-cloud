/*
 * Created by lzy on 2019-07-30 11:41.
 */
package com.lzy.demo.dubbo.client;

import com.lzy.demo.dubbo.api.SimpleService;
import com.lzy.demo.dubbo.message.SimpleRequest;
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
     * @param simpleService the simple service
     */
    @Test
    public void testClient(@Autowired SimpleService simpleService) {
        SimpleRequest simpleRequest = new SimpleRequest();
        simpleRequest.setRequest("request");
        System.out.println(simpleService.simpleService(simpleRequest));
    }

    /**
     * 测试校验
     *
     * @param simpleService the simple service
     */
    @Test
    public void testValidation(@Autowired SimpleService simpleService) {
        System.out.println(simpleService.simpleService(new SimpleRequest()));
    }
}
