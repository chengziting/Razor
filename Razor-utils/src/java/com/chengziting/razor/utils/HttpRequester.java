package com.chengziting.razor.utils;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018-03-12.
 */
public class HttpRequester {
    public String sendGet(String url){
        String result = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("close CloseableHttpResponse failed!");
                }
            }
        }

        HttpEntity entity = response.getEntity();
        if(entity != null){
            try {
                result = EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(response != null){
                    try {
                        response.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return result;
    }

    public String sendPost(String url, Map<String,String> param){
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost post = new HttpPost(url);
        if(param != null && !param.isEmpty()) {
            List<NameValuePair> requestParams = new ArrayList<NameValuePair>();
            for (Map.Entry<String, String> e : param.entrySet()) {
                requestParams.add(new BasicNameValuePair(e.getKey(), e.getValue()));
            }
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(requestParams, Consts.UTF_8);
            post.setEntity(formEntity);
        }
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
}
