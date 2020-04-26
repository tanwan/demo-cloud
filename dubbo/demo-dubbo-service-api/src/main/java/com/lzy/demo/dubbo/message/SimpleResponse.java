/*
 * Created by lzy on 2019-07-30 11:14.
 */
package com.lzy.demo.dubbo.message;

import java.io.Serializable;

/**
 * @author lzy
 * @version v1.0
 */
public class SimpleResponse implements Serializable {

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "SimpleResponse{" +
                "response='" + response + '\'' +
                '}';
    }
}
