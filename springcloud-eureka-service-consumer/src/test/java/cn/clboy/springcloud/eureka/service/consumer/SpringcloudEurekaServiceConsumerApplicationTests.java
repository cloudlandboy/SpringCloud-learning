package cn.clboy.springcloud.eureka.service.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudEurekaServiceConsumerApplicationTests {

    @Autowired
    private RibbonLoadBalancerClient loadBalanceClient;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testLoadBalance() {
        for (int i = 0; i < 50; i++) {
            ServiceInstance instance = loadBalanceClient.choose("service-provider");
            System.out.println(instance.getPort());
        }
    }

}
