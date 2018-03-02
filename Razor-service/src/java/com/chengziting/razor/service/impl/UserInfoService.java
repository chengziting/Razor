package com.chengziting.razor.service.impl;

import com.chengziting.razor.dao.IUserInfoDao;
import com.chengziting.razor.dao.base.IBaseDao;
import com.chengziting.razor.model.persistent.UserInfo;
import com.chengziting.razor.service.IUserInfoService;
import com.chengziting.razor.service.base.BaseService;
import com.sun.javafx.collections.MappingChange;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2018-01-16.
 */
@Service
public class UserInfoService extends BaseService<UserInfo,String> implements IUserInfoService {
    @Autowired
    private IUserInfoDao m_dao;
    protected IBaseDao<UserInfo,String> getDao() {
        return m_dao;
    }

    public UserInfo get(String name, String password) {
        Map<String,Object> condition = new HashMap<String, Object>();
        condition.put("Name",name);
        condition.put("Password",password);
        return getDao().getFirst(condition);
    }

    public String saveWithCheck(UserInfo userInfo) {
        Map<String,Object> condition = new HashMap<String, Object>();
        condition.put("name",userInfo.getName());
        condition.put("email",userInfo.getEmail());
        getDao().getFirst(condition);
        return null;
    }
}
