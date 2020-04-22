/*
 * Created by lzy on 2020/4/21 4:40 PM.
 */
package com.lzy.demo.service.config;

import brave.http.HttpRequestParser;
import org.springframework.cloud.sleuth.instrument.web.HttpClientRequestParser;
import org.springframework.cloud.sleuth.instrument.web.HttpServerRequestParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lzy
 * @version v1.0
 */
@Configuration
public class SleuthConfig {

    /**
     * 配置RestTemplate
     *
     * @return the rest template
     */
    @Bean
    public RestTemplate plainRestTemplate() {
        return new RestTemplate();
    }


    /**
     * 默认使用HttpRequestParser.DEFAULT
     */
    @Bean(name = {HttpClientRequestParser.NAME, HttpServerRequestParser.NAME})
    public HttpRequestParser sleuthHttpServerRequestParser() {
        return (req, context, span) -> {
            HttpRequestParser.DEFAULT.parse(req, context, span);
            String url = req.url();
            if (url != null) {
                span.tag("http.url", url);
            }
        };
    }
}
