/*
 * Created by lzy on 2019-03-05 15:52.
 */
package com.lzy.demo.service.service.impl;

import com.lzy.demo.service.service.SampleFeignService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * feign降级实现
 *
 * @author lzy
 * @version v1.0
 */
@Service
public class SampleFeignFallbackService implements SampleFeignService {
    @Override
    public Integer serverPort() {
        return 0;
    }

    @Override
    public Map<String, Object> getRequest(Map<String, Object> request, String pathVariable) {
        return null;
    }

    @Override
    public Map<String, Object> getRequest(String requestParam, String pathVariable) {
        return null;
    }

    @Override
    public Map<String, Object> postRequest(Map<String, Object> request, String pathVariable) {
        return null;
    }

    @Override
    public Map<String, Object> putRequest(Map<String, Object> request, String pathVariable) {
        return null;
    }

    @Override
    public Map<String, Object> deleteRequest(Map<String, Object> request, String pathVariable) {
        return null;
    }
}
