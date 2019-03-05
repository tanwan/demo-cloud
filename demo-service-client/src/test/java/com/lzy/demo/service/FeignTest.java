/*
 * Created by lzy on 2019-02-26 17:06.
 */
package com.lzy.demo.service;

import com.lzy.demo.service.service.SampleFeignService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.annotation.DirtiesContext;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Feign test.
 *
 * @author lzy
 * @version v1.0
 */
@EnableFeignClients
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ClientApplication.class)
@DirtiesContext
public class FeignTest {

    /**
     * 从demo-service-client获取端口
     *
     * @param sampleFeignService the sample serivce
     */
    @Test
    public void serverPort(@Autowired SampleFeignService sampleFeignService) {
        Integer port = sampleFeignService.serverPort();
        System.out.println(port);
        Assertions.assertThat(port)
                .isIn(28080, 28081);
    }

    /**
     * 测试get
     *
     * @param sampleFeignService the sample service
     */
    @Test
    public void testGet(@Autowired SampleFeignService sampleFeignService) {
        Assertions.assertThat(sampleFeignService.getRequest("requestParam", "get"))
                .containsEntry("pathVariable", "get").containsEntry("requestParam", "requestParam");

        Map<String, Object> request = new HashMap<>(1);
        request.put("requestParam", "requestParam");
        Assertions.assertThat(sampleFeignService.getRequest(request, "get"))
                .containsEntry("pathVariable", "get").containsEntry("requestParam", "requestParam");
    }


    /**
     * 测试post
     *
     * @param sampleFeignService the sample service
     */
    @Test
    public void getPost(@Autowired SampleFeignService sampleFeignService) {
        Map<String, Object> request = new HashMap<>(1);
        request.put("request", "request");
        Assertions.assertThat(sampleFeignService.postRequest(request, "post"))
                .containsEntry("pathVariable", "post").containsEntry("request", "request");
    }

    /**
     * 测试put
     *
     * @param sampleFeignService the sample service
     */
    @Test
    public void testPut(@Autowired SampleFeignService sampleFeignService) {
        Map<String, Object> request = new HashMap<>(1);
        request.put("request", "request");
        Assertions.assertThat(sampleFeignService.putRequest(request, "put"))
                .containsEntry("pathVariable", "put").containsEntry("request", "request");
    }

    /**
     * 测试delete
     *
     * @param sampleFeignService the sample service
     */
    @Test
    public void testDelete(@Autowired SampleFeignService sampleFeignService) {
        Map<String, Object> request = new HashMap<>(1);
        request.put("request", "request");
        Assertions.assertThat(sampleFeignService.deleteRequest(request, "delete"))
                .containsEntry("pathVariable", "delete").containsEntry("request", "request");
    }
}
