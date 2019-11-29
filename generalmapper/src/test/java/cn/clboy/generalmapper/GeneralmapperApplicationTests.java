package cn.clboy.generalmapper;

import cn.clboy.generalmapper.Mapper.UserMapper;
import cn.clboy.generalmapper.pojo.TbUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GeneralmapperApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<TbUser> tbUsers = userMapper.selectAll();
        System.out.println(tbUsers);
    }

}
