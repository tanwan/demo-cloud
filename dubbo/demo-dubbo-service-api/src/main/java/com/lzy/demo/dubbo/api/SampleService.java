/*
 * Created by lzy on 2019-07-30 11:10.
 */
package com.lzy.demo.dubbo.api;

import com.lzy.demo.dubbo.message.SampleRequest;
import com.lzy.demo.dubbo.message.SampleResponse;

/**
 * The interface Sample service.
 *
 * @author lzy
 * @version v1.0
 */
public interface SampleService {

    /**
     * Sample service sample response.
     *
     * @param request the request
     * @return the sample response
     */
    SampleResponse sampleService(SampleRequest request);
}
