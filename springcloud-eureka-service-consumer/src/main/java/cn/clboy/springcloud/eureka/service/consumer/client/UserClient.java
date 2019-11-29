package cn.clboy.springcloud.eureka.service.consumer.client;

import cn.clboy.springcloud.eureka.service.consumer.config.FeignLogConfiguration;
import cn.clboy.springcloud.eureka.service.consumer.pojo.TbUser;
import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author cloudlandboy
 * @Date 2019/11/26 下午8:36
 * @Since 1.0.0
 */

@FeignClient(value = "service-provider", fallback = UserClientFallback.class,configuration = FeignLogConfiguration.class)
public interface UserClient {

    @GetMapping("/user/{id}")
    TbUser getUserById(@PathVariable Long id);
}