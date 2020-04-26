/*
 * Created by lzy on 2019-07-30 11:14.
 */
package com.lzy.demo.dubbo.message;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * The type Simple request.
 *
 * @author lzy
 * @version v1.0
 */
public class SimpleRequest implements Serializable {

    @NotEmpty
    private String request;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "SimpleRequest{" +
                "request='" + request + '\'' +
                '}';
    }
}
