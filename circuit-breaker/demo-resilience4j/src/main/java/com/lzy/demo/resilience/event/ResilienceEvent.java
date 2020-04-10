/*
 * Created by lzy on 2020/4/8 8:31 AM.
 */
package com.lzy.demo.resilience.event;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.retry.Retry;

/**
 * 事件
 *
 * @author lzy
 * @version v1.0
 */
public class ResilienceEvent {


    /**
     * 添加熔断器事件
     *
     * @param circuitBreaker the circuit breaker
     */
    public static void addCircuitBreakerListener(CircuitBreaker circuitBreaker) {
        circuitBreaker.getEventPublisher()
                .onSuccess(event -> System.out.println("call success:" + event.toString()))
                .onError(event -> System.out.println("cal failed:" + event.toString()))
                .onIgnoredError(event -> System.out.println("call failed ignore:" + event.toString()))
                .onReset(event -> System.out.println("circuitBreaker reset:" + event.toString()))
                .onStateTransition(event -> System.out.println("circuitBreaker change:" + event.toString()))
                .onCallNotPermitted(event -> System.out.println("circuitBreaker open:" + event.toString()))
        ;
    }

    /**
     * 添加重试事件
     *
     * @param retry the retry
     */
    public static void addRetryListener(Retry retry) {
        retry.getEventPublisher()
                .onSuccess(event -> System.out.println("call success:" + event.toString()))
                .onRetry(event -> System.out.println("retry:" + event.toString()))
                .onError(event -> System.out.println("call failed:" + event.toString()))
                .onIgnoredError(event -> System.out.println("call failed ignore:" + event.toString()));
    }


    /**
     * 添加舱壁事件
     *
     * @param bulkhead the bulkhead
     */
    public static void addBulkheadListener(Bulkhead bulkhead) {
        bulkhead.getEventPublisher()
                .onCallFinished(event -> System.out.println("call finish:" + event.toString()))
                .onCallPermitted(event -> System.out.println("call permitted:" + event.toString()))
                .onCallRejected(event -> System.out.println("call rejected:" + event.toString()));
    }

    /**
     * 添加限流事件
     *
     * @param rateLimiter the rate limiter
     */
    public static void addRateLimiterListener(RateLimiter rateLimiter) {
        rateLimiter.getEventPublisher()
                .onSuccess(event -> System.out.println("call success:" + event.toString()))
                .onFailure(event -> System.out.println("call failed:" + event.toString()));
    }
}
