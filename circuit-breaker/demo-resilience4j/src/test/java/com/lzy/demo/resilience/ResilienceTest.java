/*
 * Created by lzy on 2020/4/3 10:28 AM.
 */
package com.lzy.demo.resilience;

import com.lzy.demo.resilience.event.ResilienceEvent;
import com.lzy.demo.resilience.exception.IgnoreException;
import com.lzy.demo.resilience.service.ResilienceService;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadRegistry;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.vavr.control.Try;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;

/**
 * 测试代码使用resilience
 *
 * @author lzy
 * @version v1.0
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(ThreadEachCallback.class)
public class ResilienceTest {

    @Resource
    private ResilienceService resilienceService;

    @Resource
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @Resource
    private RetryRegistry retryRegistry;

    @Resource
    private BulkheadRegistry bulkheadRegistry;

    @Resource
    private ThreadPoolBulkheadRegistry threadPoolBulkheadRegistry;

    @Resource
    private RateLimiterRegistry rateLimiterRegistry;

    /**
     * 添加事件
     */
    @BeforeAll
    public void addEvent() {
        ResilienceEvent.addCircuitBreakerListener(circuitBreakerRegistry.circuitBreaker(ResilienceService.SIMPLE_BACKEND));
        ResilienceEvent.addRetryListener(retryRegistry.retry(ResilienceService.SIMPLE_BACKEND));
        ResilienceEvent.addBulkheadListener(bulkheadRegistry.bulkhead(ResilienceService.SIMPLE_BACKEND));
        ResilienceEvent.addRateLimiterListener(rateLimiterRegistry.rateLimiter(ResilienceService.SIMPLE_BACKEND));
    }


    /**
     * 测试抛出异常
     *
     * @param repetitionInfo the repetition info
     */
    @RepeatedTest(10)
    public void testException(RepetitionInfo repetitionInfo) {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(ResilienceService.SIMPLE_BACKEND);
        if (repetitionInfo.getCurrentRepetition() <= 5) {
            //熔断未打开的时候,抛出IOException
            Assertions.assertThatCode(() -> circuitBreaker.executeCheckedSupplier(() -> resilienceService.exception(IOException.class.getSimpleName())))
                    .isInstanceOf(IOException.class);
        } else {
            //熔断打开后,抛出CallNotPermittedException
            Assertions.assertThatCode(() -> circuitBreaker.executeCheckedSupplier(() -> resilienceService.exception(IOException.class.getSimpleName())))
                    .isInstanceOf(CallNotPermittedException.class);
        }
    }

    /**
     * 测试抛出忽略的异常,不需要解发熔断
     */
    @RepeatedTest(10)
    public void textIgnoreException() {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(ResilienceService.SIMPLE_BACKEND);
        Assertions.assertThatCode(() -> circuitBreaker.executeCheckedSupplier(() -> resilienceService.exception(IgnoreException.class.getSimpleName())))
                .isInstanceOf(IgnoreException.class);
    }

    /**
     * 测试降级
     *
     * @throws IOException the io exception
     */
    @RepeatedTest(10)
    public void testFallback() throws IOException {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(ResilienceService.SIMPLE_BACKEND);
        Try<String> result = Try.of(circuitBreaker.decorateCheckedSupplier(() -> resilienceService.exception(IOException.class.getSimpleName())))
                //熔断器打开后的降级
                .recover(CallNotPermittedException.class, t -> "circuit breaker open")
                //熔断器未打开失败的降级
                .recover(t -> "fallback");
        System.out.println(result.get());
    }

    /**
     * 测试慢调用
     *
     * @param repetitionInfo the repetition info
     * @throws Throwable the throwable
     */
    @RepeatedTest(10)
    public void testSlowCall(RepetitionInfo repetitionInfo) throws Throwable {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(ResilienceService.SIMPLE_BACKEND);
        if (repetitionInfo.getCurrentRepetition() <= 5) {
            //熔断未打开的时候,成功执行
            Assertions.assertThat(circuitBreaker.executeCheckedSupplier(() -> resilienceService.slowCall()))
                    .isEqualTo("slow");
        } else {
            //熔断打开后,抛出CallNotPermittedException
            Assertions.assertThatCode(() -> circuitBreaker.executeCheckedSupplier(() -> resilienceService.slowCall()))
                    .isInstanceOf(CallNotPermittedException.class);
        }
    }


    /**
     * 测试重试
     *
     * @throws IOException the io exception
     */
    @RepeatedTest(10)
    public void testRetry() throws IOException {
        Try<String> result = Try.of(Retry
                .decorateCheckedSupplier(
                        retryRegistry.retry(ResilienceService.SIMPLE_BACKEND),
                        circuitBreakerRegistry.circuitBreaker(ResilienceService.SIMPLE_BACKEND)
                                .decorateCheckedSupplier(() -> resilienceService.retry(IOException.class.getSimpleName()))))
                //熔断器未打开失败的降级
                .recover(t -> "retry fallback");
        System.out.println(result.get());
    }

    /**
     * 测试重试和熔断
     *
     * @throws IOException the io exception
     */
    @RepeatedTest(10)
    public void retryWithCircuitBreaker() throws IOException {
        Try<String> result = Try.of(Retry
                .decorateCheckedSupplier(retryRegistry.retry(ResilienceService.SIMPLE_BACKEND),
                        () -> resilienceService.retry(IOException.class.getSimpleName())))
                //熔断器未打开失败的降级
                .recover(t -> "retry fallback");
        System.out.println(result.get());
    }


    /**
     * 修改熔断器配置
     */
    protected void changeCircuitBreakerConfig() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                //最小调用次数修改为2
                .minimumNumberOfCalls(2)
                .slidingWindowSize(10)
                //使用断言判断是否记录异常
                .recordException(e -> true)
                .build();
        //先删除原有的配置
        circuitBreakerRegistry.find(ResilienceService.SIMPLE_BACKEND)
                .ifPresent(circuitBreaker -> circuitBreakerRegistry.remove(ResilienceService.SIMPLE_BACKEND));
        //再添加新的配置
        circuitBreakerRegistry.circuitBreaker(ResilienceService.SIMPLE_BACKEND, circuitBreakerConfig);
    }

    /**
     * 测试动态配置
     *
     */
    @Test
    public void testDynamicConfig() {
        changeCircuitBreakerConfig();
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(ResilienceService.SIMPLE_BACKEND);
        for (int i = 0; i < 2; i++) {
            Assertions.assertThatCode(() -> circuitBreaker.executeCheckedSupplier(() -> resilienceService.exception(IOException.class.getSimpleName())))
                    .isInstanceOf(IOException.class);
        }
        Assertions.assertThatCode(() -> circuitBreaker.executeCheckedSupplier(() -> resilienceService.exception(IOException.class.getSimpleName())))
                .isInstanceOf(CallNotPermittedException.class);

    }


    /**
     * 测试舱壁
     *
     * @param executorService the executor service
     */
    @Test
    public void testBulkhead(ExecutorService executorService) {
        Bulkhead bulkhead = bulkheadRegistry.bulkhead(ResilienceService.SIMPLE_BACKEND);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    Try<String> result = Try.of(Bulkhead.decorateCheckedSupplier(bulkhead, () -> resilienceService.bulkhead()))
                            //降级
                            .recover(Exception.class, t -> "bulkhead fallback");
                    System.out.println(LocalTime.now() + ":" + result.get());
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }
    }

    /**
     * 测试使用同一个舱壁
     *
     * @param executorService the executor service
     */
    @Test
    public void testUseSameBulkhead(ExecutorService executorService) {
        //使用同一个舱壁
        Bulkhead bulkhead = bulkheadRegistry.bulkhead(ResilienceService.SIMPLE_BACKEND);
        for (int i = 0; i < 5; i++) {
            //虽然调用不同的接口,但是因为使用的是同一个舱壁,因此共享同一个并发限制
            executorService.submit(() -> {
                try {
                    System.out.println(LocalTime.now() + ":" + bulkhead.executeCheckedSupplier(() -> resilienceService.bulkhead()));
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
            executorService.submit(() -> {
                try {
                    System.out.println(LocalTime.now() + ":" + bulkhead.executeCheckedSupplier(() -> resilienceService.useSameBulkhead()));
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }
    }

    /**
     * 测试基于固定线程池的舱壁
     *
     * @param executorService the executor service
     */
    @Test
    public void testThreadPoolBulkhead(ExecutorService executorService) {
        ThreadPoolBulkhead threadPoolBulkhead = threadPoolBulkheadRegistry.bulkhead(ResilienceService.SIMPLE_BACKEND);
        for (int i = 0; i < 10; i++) {
            //超过等待队列的将被丢弃
            executorService.submit(() -> {
                threadPoolBulkhead.executeSupplier(() -> resilienceService.threadPoolBulkhead()
                        .thenAccept(t -> System.out.println(LocalTime.now() + ":" + t))
                );
            });
        }
    }

    /**
     * 测试限流
     */
    @Test
    public void testRateLimit() {
        RateLimiter rateLimiter = rateLimiterRegistry.rateLimiter(ResilienceService.SIMPLE_BACKEND);
        for (int i = 0; i < 10; i++) {
            Try<String> result = Try.of(RateLimiter.decorateCheckedSupplier(rateLimiter, () -> resilienceService.rateLimit()))
                    //降级
                    .recover(RequestNotPermitted.class, t -> "rateLimit fallback");
            System.out.println(result.get());
        }
    }


    /**
     * 熔断状态
     */
    @AfterEach
    public void showCircuitBreakerStatus() {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker(ResilienceService.SIMPLE_BACKEND);
        CircuitBreaker.Metrics metrics = circuitBreaker.getMetrics();
        // 当前失败率,没计算失败率时为-1
        float failureRate = metrics.getFailureRate();
        // 当前慢调用率,没计算前时-1
        float slowCallRate = metrics.getSlowCallRate();
        // 当前慢调用次数
        int numberOfSlowCalls = metrics.getNumberOfSlowCalls();
        // 当前慢调用成功次数
        int numberOfSlowSuccessfulCalls = metrics.getNumberOfSlowSuccessfulCalls();
        // 当前慢调用失败次数
        int numberOfSlowFailedCalls = metrics.getNumberOfSlowFailedCalls();
        // 熔断之前的调用次数
        int bufferedCalls = metrics.getNumberOfBufferedCalls();
        // 熔断之前的失败调用数
        int failedCalls = metrics.getNumberOfFailedCalls();
        // 当前的成功调用数
        int successCalls = metrics.getNumberOfSuccessfulCalls();
        // 当前不允许执行的调用数
        long notPermittedCalls = metrics.getNumberOfNotPermittedCalls();
        System.out.println(LocalTime.now() + " state=" + circuitBreaker.getState() +
                ", metrics[ failureRate=" + failureRate +
                ", slowCallRate=" + slowCallRate +
                ", numberOfSlowCalls=" + numberOfSlowCalls +
                ", numberOfSlowSuccessfulCalls=" + numberOfSlowSuccessfulCalls +
                ", numberOfSlowFailedCalls=" + numberOfSlowFailedCalls +
                ", bufferedCalls=" + bufferedCalls +
                ", failedCalls=" + failedCalls +
                ", successCalls=" + successCalls +
                ", notPermittedCalls=" + notPermittedCalls +
                " ]");
    }


}
