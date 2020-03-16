/*
 * Created by lzy on 2019-02-25 09:39.
 */
package com.lzy.demo.service.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * The type Ribbon config.
 *
 * @author lzy
 * @version v1.0
 */
@Configuration
public class RibbonConfig {

    /**
     * 配置RestTemplate
     *
     * @return the rest template
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Load balance rule rule.
     *
     * @return the rule
     */
    @Bean
    public IRule loadBalanceRule() {
        return new RandomRule();
    }

}
