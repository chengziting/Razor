package com.chengziting.razor.test.controller;

import com.chengziting.razor.core.exception.ServiceException;
import com.chengziting.razor.dao.IUserInfoDao;
import com.chengziting.razor.model.persistent.Roles;
import com.chengziting.razor.model.persistent.UserInfo;
import com.chengziting.razor.test.BaseTest;
import com.chengziting.razor.web.model.ViewModel;
import com.chengziting.razor.web.model.vm.SimpleRoleModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jdk.internal.dynalink.support.TypeUtilities;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by user on 2018-03-08.
 */
public class testAdministratorController extends BaseTest{

    @Autowired
    private IUserInfoDao userInfoDao;

    @Test
    public void testGetRoleList() throws Exception {
        System.out.println("=============start do get=============");

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/admin/rolelist")
                .accept(MediaType.ALL)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        ViewModel<List<SimpleRoleModel>> vm = new Gson().fromJson(content,ViewModel.class);

    }

    @Test
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void testLazyLoad() {
        List<UserInfo> userInfoList = userInfoDao.getList();
        if(userInfoList.size()>0){
            UserInfo firstUser = userInfoList.get(0);
            System.out.println(firstUser.getName());
            firstUser.setName("czt"+2);

            userInfoDao.saveOrUpdate(firstUser);
//            throw new ServiceException();
        }
    }
}
