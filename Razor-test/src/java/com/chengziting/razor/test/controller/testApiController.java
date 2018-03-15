package com.chengziting.razor.test.controller;

import com.chengziting.razor.test.ApiBaseTest;
import com.chengziting.razor.test.ApiRequest;
import com.chengziting.razor.utils.HttpRequester;
import com.chengziting.razor.utils.RazorApi;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.net.www.http.HttpClient;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2018-03-12.
 */
public class testApiController extends ApiBaseTest {
    @Autowired
    private RazorApi razorApi;
    @Autowired
    private HttpRequester requester;

    @Test
    public void testInvokApi(){
        String url = razorApi.getApiUrl()+"/testapi/test";
        String content = requester.sendGet(url);
        System.out.print("api response="+content);
    }

    @Test
    public void testInvokApi1(){
        String url = razorApi.getApiUrl() + "/testapi/testpost";
        Map<String,String> param = new HashMap<String, String>();
        param.put("p","22");
        String content = requester.sendPost(url,param);
        System.out.println("api response="+content);
    }
}
