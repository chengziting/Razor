package com.chengziting.razor.service.impl;

import com.chengziting.razor.dao.IUsersDao;
import com.chengziting.razor.dao.base.IBaseDao;
import com.chengziting.razor.model.persistent.Users;
import com.chengziting.razor.service.IUsersService;
import com.chengziting.razor.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2018-01-16.
 */
@Service
public class UsersService extends BaseService<Users,String> implements IUsersService {
    @Autowired
    private IUsersDao m_dao;
    protected IBaseDao<Users,String> getDao() {
        return m_dao;
    }

    public Users get(String name, String password) {
        Map<String,Object> condition = new HashMap<String, Object>();
        condition.put("Name",name);
        condition.put("Password",password);
        return getDao().getFirst(condition);
    }

    public String saveWithCheck(Users users) {
        Map<String,Object> condition = new HashMap<String, Object>();
        condition.put("name", users.getName());
        condition.put("email", users.getEmail());
        getDao().getFirst(condition);
        return null;
    }
}
