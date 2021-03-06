/*
 * Created by lzy on 2019-03-05 16:06.
 */
package com.lzy.demo.service.config;

import com.lzy.demo.service.service.SimpleFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * feign降级配置,这个类不需要添加@Configuration
 *
 * @author lzy
 * @version v1.0
 */
public class FeignFallbackConfig {

    /**
     * Feign fallback factory fallback factory.
     *
     * @return the fallback factory
     */
    @Bean
    public FallbackFactory<SimpleFeignService> feignFallbackFactory() {
        return new FallbackFactory.Default<>(new SimpleFeignService() {
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

            @Override
            public String sleuth() {
                return null;
            }

            @Override
            public String sleuth2() {
                return null;
            }
        });
    }
}
