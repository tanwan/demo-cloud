/*
 * Created by lzy on 2019-07-30 18:50.
 */
package com.lzy.demo.dubbo.client;

import com.lzy.demo.dubbo.api.SimpleService;
import com.lzy.demo.dubbo.message.SimpleRequest;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 使用注解配置dubbo
 *
 * @author lzy
 * @version v1.0
 */
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig({ClientAnnotationTest.class})
@PropertySource("classpath:/client.properties")
@EnableDubbo(scanBasePackages = "com.lzy.demo.dubbo.client")
public class ClientAnnotationTest {


    /**
     * 注解的属性同dubbo:reference
     */
    @Reference(validation = "true")
    private SimpleService simpleService;

    /**
     * 测试客户端
     */
    @Test
    public void testClient() {
        SimpleRequest simpleRequest = new SimpleRequest();
        simpleRequest.setRequest("request");
        System.out.println(simpleService.simpleService(simpleRequest));
    }
}
