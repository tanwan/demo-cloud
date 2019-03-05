/*
 * Created by lzy on 2019-02-25 15:11.
 */
package com.lzy.demo.service.service;

import com.lzy.demo.service.config.FeignFallbackConfig;
import com.lzy.demo.service.constant.Constants;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 调用feign的service
 * 注解(@RequestParam,@PathVariable)的name不能省略
 * 如果使用fallbackFactory,那么必须指定configuration
 *
 * @author lzy
 * @version v1.0
 */
@FeignClient(value = Constants.DEMO_SERVICE_SERVER_NAME, fallbackFactory = FallbackFactory.Default.class, configuration = FeignFallbackConfig.class)
public interface SampleFeignService {

    /**
     * Server port integer.
     *
     * @return the integer
     */
    @GetMapping("/port")
    Integer serverPort();

    /**
     * Gets request.
     *
     * @param request      the request
     * @param pathVariable the path variable
     * @return the request
     */
    @GetMapping("/get/{pathVariable}")
    Map<String, Object> getRequest(@RequestParam Map<String, Object> request, @PathVariable("pathVariable") String pathVariable);

    /**
     * Gets request.
     *
     * @param requestParam the request param
     * @param pathVariable the path variable
     * @return the request
     */
    @GetMapping("/get/{pathVariable}")
    Map<String, Object> getRequest(@RequestParam("requestParam") String requestParam, @PathVariable("pathVariable") String pathVariable);


    /**
     * Post request string.
     *
     * @param request      the request
     * @param pathVariable the path variable
     * @return the string
     */
    @PostMapping("/post/{pathVariable}")
    Map<String, Object> postRequest(@RequestBody Map<String, Object> request, @PathVariable("pathVariable") String pathVariable);

    /**
     * Put request string.
     *
     * @param request      the request
     * @param pathVariable the path variable
     * @return the string
     */
    @PostMapping("/put/{pathVariable}")
    Map<String, Object> putRequest(@RequestBody Map<String, Object> request, @PathVariable("pathVariable") String pathVariable);

    /**
     * Delete request string.
     *
     * @param request      the request
     * @param pathVariable the path variable
     * @return the string
     */
    @PostMapping("/delete/{pathVariable}")
    Map<String, Object> deleteRequest(@RequestBody Map<String, Object> request, @PathVariable("pathVariable") String pathVariable);
}
