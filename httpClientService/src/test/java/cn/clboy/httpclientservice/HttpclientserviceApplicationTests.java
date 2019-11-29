package cn.clboy.httpclientservice;

import cn.clboy.httpclientservice.Mapper.UserMapper;
import cn.clboy.httpclientservice.pojo.TbUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HttpclientserviceApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        TbUser user = userMapper.selectByPrimaryKey(1);

        ObjectMapper mapper=new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(user);
        System.out.println(jsonStr);
    }

}
