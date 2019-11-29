package cn.clboy.springcloud.eureka.service.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author cloudlandboy
 * @Date 2019/11/26 下午9:42
 * @Since 1.0.0
 */

@Configuration
public class FeignLogConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
