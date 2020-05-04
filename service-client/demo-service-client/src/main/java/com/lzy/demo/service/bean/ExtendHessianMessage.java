/*
 * Created by lzy on 2020/5/4 7:27 AM.
 */
package com.lzy.demo.service.bean;

/**
 * @author lzy
 * @version v1.0
 */
public class ExtendHessianMessage extends HessianMessage {

    /**
     * 跟父类属性相同,hessian序列化时,这个字段会为null
     */
    private String string;


    @Override
    public String getString() {
        return string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }
}
