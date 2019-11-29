package cn.clboy.springcloud.eureka.service.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author cloudlandboy
 * @Date 2019/11/25 下午5:20
 * @Since 1.0.0
 */

//@RestController
@RequestMapping("user")
@DefaultProperties(
        defaultFallback = "defaultFallback",
        commandProperties = {
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
        })
public class UserController_bak {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/{id}")
    @HystrixCommand
    public String getUserById(@PathVariable Long id) {
        if (id == 1) {
            throw new RuntimeException("忙碌中......");
        }
        //直接通过服务名称调用
        String baseUrl = "http://service-provider/user/";
        return restTemplate.getForObject(baseUrl + id, String.class);
    }

    public String defaultFallback() {
        return "请求繁忙，请稍后再试！";
    }
}