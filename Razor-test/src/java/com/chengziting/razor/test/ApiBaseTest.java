package com.chengziting.razor.test;

import com.chengziting.razor.service.IUserInfoService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by user on 2018-03-12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//(value = "web")
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml",
        "classpath:application-context-model.xml",
        "classpath:application-context-service.xml",
        "classpath:application-context-dao.xml",
        "classpath:dispatcher-api-servlet.xml"
})
public class ApiBaseTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    protected WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;
    // 模拟request,response
    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;

    @Autowired
    protected IUserInfoService userInfoService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }

}
