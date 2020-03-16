/*
 * Created by lzy on 2019-07-30 11:31.
 */
package com.lzy.demo.dubbo.server;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 使用xml配置dubbo
 *
 * @author lzy
 * @version v1.0
 */
@ImportResource("classpath:server.xml")
@ExtendWith(SpringExtension.class)
@SpringJUnitConfig({ServerXMLTest.class, SampleServiceSpringImpl.class})
public class ServerXMLTest {


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
