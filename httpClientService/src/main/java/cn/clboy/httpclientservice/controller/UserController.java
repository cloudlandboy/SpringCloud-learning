package cn.clboy.httpclientservice.controller;

import cn.clboy.httpclientservice.Mapper.UserMapper;
import cn.clboy.httpclientservice.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author cloudlandboy
 * @Date 2019/11/25 下午12:22
 * @Since 1.0.0
 */

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<TbUser> users() {
        return userMapper.selectAll();
    }

    @PostMapping(value = "/user")
    public TbUser add(TbUser user, HttpServletRequest request) {
        userMapper.insert(user);
        return user;
    }
}