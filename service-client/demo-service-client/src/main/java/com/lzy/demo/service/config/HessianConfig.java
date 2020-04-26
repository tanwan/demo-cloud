/*
 * Created by lzy on 2020/4/22 4:13 PM.
 */
package com.lzy.demo.service.config;

import com.lzy.demo.service.service.SimpleHessianService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * @author lzy
 * @version v1.0
 */
@Configuration
@Profile("hessian")
public class HessianConfig {

    /**
     * @return HessianProxyFactoryBean
     */
    @Bean
    public HessianProxyFactoryBean hessianInvoker() {
        HessianProxyFactoryBean invoker = new HessianProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:28010/simpleHessianService");
        //使用hessian2
        invoker.setHessian2(true);
        invoker.setServiceInterface(SimpleHessianService.class);
        return invoker;
    }
}
