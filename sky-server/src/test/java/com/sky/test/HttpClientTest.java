package com.sky.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class HttpClientTest {

    /**
     * 测试过HttpClient发送GET方式请求
     */
    @Test
    public void testGET() throws Exception{
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建请求对象
        HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");

        //发送请求,并接收响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //获得服务器返回的响应码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("服务端返回的响应码："+statusCode);

        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println("服务端返回的数据为："+body);

        //关闭资源
        response.close();
        httpClient.close();
    }
    /**
     * 测试过HttpClient发送POST方式请求
     */
    @Test
    public void testPOST()throws Exception{
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建请求对象
        HttpPost httpPost = new HttpPost("http://localhost:8080/admin/employee/login");

        //通过JsonObject构造一个json格式字符串
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","admin");
        jsonObject.put("password","123456");

        StringEntity entity = new StringEntity(jsonObject.toString());
        //指定编码请求方式
        entity.setContentEncoding("utf-8");
        //指定数据格式
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        //发送请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("响应码为："+statusCode);
        //获取响应数据
        HttpEntity entity1 = response.getEntity();
        String body = EntityUtils.toString(entity1);
        System.out.println("响应数据为："+body);

        //关闭连接
        response.close();
        httpClient.close();
    }
}
