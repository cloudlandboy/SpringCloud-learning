package cn.clboy.service.consumer.controller;

import cn.clboy.service.consumer.pojo.TbUser;
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

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{id}")
    public TbUser getUserById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:8080/user/" + id, TbUser.class);
    }
}