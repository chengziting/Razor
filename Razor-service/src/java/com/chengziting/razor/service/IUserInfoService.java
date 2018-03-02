package com.chengziting.razor.service;

import com.chengziting.razor.model.persistent.UserInfo;
import com.chengziting.razor.service.base.IBaseService;

/**
 * Created by user on 2018-01-16.
 */
public interface IUserInfoService extends IBaseService<UserInfo,String> {
    UserInfo get(String name,String password);
    String saveWithCheck(UserInfo userInfo);
}
