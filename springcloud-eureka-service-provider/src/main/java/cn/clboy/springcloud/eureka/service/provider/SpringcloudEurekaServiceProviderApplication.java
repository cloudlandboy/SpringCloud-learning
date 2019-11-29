package cn.clboy.springcloud.eureka.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "cn.clboy.springcloud.eureka.service.provider.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudEurekaServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaServiceProviderApplication.class, args);
	}

}
