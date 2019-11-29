package cn.clboy.springcloud.eureka.service.consumer.client;

import cn.clboy.springcloud.eureka.service.consumer.pojo.TbUser;
import org.springframework.stereotype.Component;

/**
 * @Author cloudlandboy
 * @Date 2019/11/26 下午9:15
 * @Since 1.0.0
 */

@Component
public class UserClientFallback implements UserClient {

    @Override
    public TbUser getUserById(Long id) {
        TbUser tbUser=new TbUser();
        tbUser.setUsername("服务器繁忙，请稍后再试！");
        return tbUser;
    }
}