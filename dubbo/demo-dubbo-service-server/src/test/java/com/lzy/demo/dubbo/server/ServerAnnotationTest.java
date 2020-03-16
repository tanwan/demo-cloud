/*
 * Created by lzy on 2019-07-30 17:08.
 */
package com.lzy.demo.dubbo.server;

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
@SpringJUnitConfig({ServerAnnotationTest.class})
@EnableDubbo(scanBasePackages = "com.lzy.demo.dubbo.server")
@PropertySource("classpath:/server.properties")
public class ServerAnnotationTest {


    /**
     * 测试服务端
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void testServer() throws InterruptedException {
        Thread.sleep(1000000);
    }
}
