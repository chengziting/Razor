package com.chengziting.razor.test;

import com.chengziting.razor.service.IUsersService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by user on 2018-03-08.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration//(value = "web")
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml",
        "classpath:application-context-model.xml",
        "classpath:application-context-service.xml",
        "classpath:application-context-dao.xml",
        "classpath:dispatcher-servlet.xml"})
public class testService extends AbstractJUnit4SpringContextTests{
    @Autowired
    protected WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;

    @Autowired
    protected IUsersService usersService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {
        System.out.println("=============start do get=============");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/account/register").accept(MediaType.ALL))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
