package com.chengziting.razor.service.impl;

import com.chengziting.razor.dao.base.IBaseDao;
import com.chengziting.razor.model.persistent.UserRole;
import com.chengziting.razor.service.IUserRoleService;
import com.chengziting.razor.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2018-03-06.
 */
@Service
public class UserRoleService extends BaseService<UserRole,String > implements IUserRoleService {
    @Autowired
    private IBaseDao<UserRole,String> m_dao;
    protected IBaseDao<UserRole, String> getDao() {
        return m_dao;
    }
}
