package cn.clboy.httpclientconsumer;

import cn.clboy.pojo.TbUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import org.apache.catalina.User;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class HttpclientconsumerApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void restTemplateGet() {
        List<TbUser> users = restTemplate.getForObject("http://localhost:8080/user", List.class);
        System.out.println("users --> " + users);
    }

    //1. 安装浏览器
    public CloseableHttpClient httpClient;

    @BeforeEach
    public void init() {
        //2. 打开浏览器
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void get() throws IOException {
        //2. 创建get请求
        HttpGet getRequest = new HttpGet("http://localhost:8080/user");
        String response = httpClient.execute(getRequest, new BasicResponseHandler());

        ObjectMapper mapper = new ObjectMapper();
        CollectionLikeType type = mapper.getTypeFactory().constructCollectionType(List.class, TbUser.class);
        List<TbUser> users = mapper.readValue(response, type);
        System.out.println(users);
    }

    @Test
    public void post() throws IOException {
        //创建post请求
        HttpPost postRequest = new HttpPost("http://localhost:8080/user");
//        postRequest.setHeader("content-type","application/json;charset=UTF-8");
        //表单数据
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("username", "lisi"));
        formparams.add(new BasicNameValuePair("password", "123456"));
        formparams.add(new BasicNameValuePair("phone", "17633547812"));
        formparams.add(new BasicNameValuePair("created", "2019/10/07"));

        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "utf-8");
        postRequest.setEntity(entity);

        String response = httpClient.execute(postRequest, new BasicResponseHandler());

        ObjectMapper mapper = new ObjectMapper();
        TbUser tbUser = mapper.readValue(response, TbUser.class);
        System.out.println(tbUser);
    }

    @Test
    public void testJsonToMap() throws IOException {
        Map<String, Object> map = new HashMap<>();

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<TbUser>> listTypeReference = new TypeReference<List<TbUser>>() {
        };

        //使用TypeReference，它是一个抽象类
        List<TbUser> users = mapper.readValue(new URL("http://localhost:8080/user"), listTypeReference);

        for (TbUser user : users) {
            map.put(user.getUsername(), user);
        }

        //序列化
        String mapJson = mapper.writeValueAsString(map);
        System.out.println(mapJson);

        //反序列化，使用类型工厂
        Map<String, Object> result = mapper.readValue(mapJson, mapper.getTypeFactory().constructMapType(HashMap.class, String.class, TbUser.class));


        System.out.println(result);


    }

}
