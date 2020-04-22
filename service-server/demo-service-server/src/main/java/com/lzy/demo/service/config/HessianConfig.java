/*
 * Created by lzy on 2020/4/22 2:31 PM.
 */
package com.lzy.demo.service.config;

import com.lzy.demo.service.service.SampleHessianService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * @author lzy
 * @version v1.0
 */
@Configuration
@Profile("hessian")
public class HessianConfig {


    /**
     * sampleHessianService,bean名为调用的url的名称
     */
    @Bean("/sampleHessianService")
    public HessianServiceExporter sampleHessianService(SampleHessianService sampleHessianService) {
        HessianServiceExporter exporter = new HessianServiceExporter();
        //设置service
        exporter.setService(sampleHessianService);
        exporter.setServiceInterface(SampleHessianService.class);
        return exporter;
    }

}
