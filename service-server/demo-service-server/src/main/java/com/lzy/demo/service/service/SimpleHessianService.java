/*
 * Created by lzy on 2020/4/22 2:39 PM.
 */
package com.lzy.demo.service.service;

import com.lzy.demo.service.bean.HessianMessage;

/**
 * @author lzy
 * @version v1.0
 */
public interface SimpleHessianService {

    /**
     * @param hessianMessage hessianMessage
     * @return hessianMessage
     */
    HessianMessage simpleHessian(HessianMessage hessianMessage);
}
