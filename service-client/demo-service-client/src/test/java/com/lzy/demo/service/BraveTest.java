/*
 * Created by lzy on 2020/4/22 10:54 AM.
 */
package com.lzy.demo.service;

import com.lzy.demo.service.service.BraveService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * @author lzy
 * @version v1.0
 */
@SpringBootTest
@ActiveProfiles("sleuth")
public class BraveTest {


    @Resource
    private BraveService braveService;


    /**
     * 测试startScopedSpan
     */
    @Test
    public void testStartScopedSpan() {
        braveService.startScopedSpan();
    }

    /**
     * 测试withSpanInScope
     */
    @Test
    public void testWithSpanInScope() {
        braveService.withSpanInScope();
    }

    /**
     * 测试useAnnotation
     */
    @Test
    public void testUseAnnotation() {
        braveService.useAnnotation();
    }
}
