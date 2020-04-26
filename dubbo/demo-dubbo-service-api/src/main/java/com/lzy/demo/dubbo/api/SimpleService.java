/*
 * Created by lzy on 2019-07-30 11:10.
 */
package com.lzy.demo.dubbo.api;

import com.lzy.demo.dubbo.message.SimpleRequest;
import com.lzy.demo.dubbo.message.SimpleResponse;

/**
 * The interface Simple service.
 *
 * @author lzy
 * @version v1.0
 */
public interface SimpleService {

    /**
     * Simple service simple response.
     *
     * @param request the request
     * @return the simple response
     */
    SimpleResponse simpleService(SimpleRequest request);
}
