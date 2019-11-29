package cn.clboy.springcloud.eureka.service.provider.controller;


import cn.clboy.springcloud.eureka.service.provider.pojo.TbUser;
import cn.clboy.springcloud.eureka.service.provider.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cloudlandboy
 * @Date 2019/11/25 下午5:05
 * @Since 1.0.0
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public TbUser queryUserById(@PathVariable Long id) {
        return userService.queryById(id);
    }
}