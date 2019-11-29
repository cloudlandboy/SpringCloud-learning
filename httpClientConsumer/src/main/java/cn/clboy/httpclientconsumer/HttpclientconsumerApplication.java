package cn.clboy.httpclientconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HttpclientconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpclientconsumerApplication.class, args);
    }

    @Bean
    public RestTemplate resttemplate() {
        return new RestTemplate();
    }
}
