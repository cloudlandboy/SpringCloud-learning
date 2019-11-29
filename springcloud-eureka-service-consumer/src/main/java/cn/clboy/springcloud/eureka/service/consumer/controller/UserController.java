package cn.clboy.springcloud.eureka.service.consumer.controller;

import cn.clboy.springcloud.eureka.service.consumer.client.UserClient;
import cn.clboy.springcloud.eureka.service.consumer.pojo.TbUser;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author cloudlandboy
 * @Date 2019/11/26 下午8:29
 * @Since 1.0.0
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public TbUser getUserById(@PathVariable Long id) {
        return userClient.getUserById(id);
    }
}