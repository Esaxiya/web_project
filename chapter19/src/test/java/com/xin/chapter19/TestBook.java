package com.xin.chapter19;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class TestBook {


    @Test
    public void testInput() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/book_list");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.getProtocolVersion());

        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/book_input");



    }

    public static String doPost(String url, Map<String,String> map, String charset){
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try{
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));
            }
            if(list.size() > 0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Test
    public void testpost(){
        Map<String,String> params = new HashMap<>();
        params.put("title","sssss");
        params.put("author","author");
        params.put("isbn","6768687789");

        TestBook.doPost("http://127.0.0.1:8080/book_input",params,"UTF-8");

    }
}
