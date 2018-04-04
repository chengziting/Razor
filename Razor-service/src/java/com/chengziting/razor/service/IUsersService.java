package com.chengziting.razor.service;

import com.chengziting.razor.model.persistent.Users;
import com.chengziting.razor.service.base.IBaseService;

/**
 * Created by user on 2018-01-16.
 */
public interface IUsersService extends IBaseService<Users,String> {
    Users get(String name, String password);
    String saveWithCheck(Users users);
}
