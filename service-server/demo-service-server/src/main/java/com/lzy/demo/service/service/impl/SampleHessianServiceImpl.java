/*
 * Created by lzy on 2020/4/22 4:01 PM.
 */
package com.lzy.demo.service.service.impl;

import com.lzy.demo.service.bean.HessianMessage;
import com.lzy.demo.service.service.SampleHessianService;
import org.springframework.stereotype.Service;

/**
 * @author lzy
 * @version v1.0
 */
@Service
public class SampleHessianServiceImpl implements SampleHessianService {
    @Override
    public HessianMessage sampleHessian(HessianMessage hessianMessage) {
        return hessianMessage;
    }
}
