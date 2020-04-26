/*
 * Created by lzy on 2020/4/22 4:01 PM.
 */
package com.lzy.demo.service.service.impl;

import com.lzy.demo.service.bean.HessianMessage;
import com.lzy.demo.service.service.SimpleHessianService;
import org.springframework.stereotype.Service;

/**
 * @author lzy
 * @version v1.0
 */
@Service
public class SimpleHessianServiceImpl implements SimpleHessianService {
    @Override
    public HessianMessage simpleHessian(HessianMessage hessianMessage) {
        return hessianMessage;
    }
}
