package com.chengziting.razor.service.impl;

import com.chengziting.razor.dao.IRolesDao;
import com.chengziting.razor.dao.base.IBaseDao;
import com.chengziting.razor.dao.impl.RolesDao;
import com.chengziting.razor.model.persistent.Roles;
import com.chengziting.razor.service.IRolesService;
import com.chengziting.razor.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2018-01-05.
 */
@Service
public class RolesService extends BaseService<Roles,String> implements IRolesService {
    @Autowired
    private IRolesDao m_dao;
    protected IBaseDao<Roles, String> getDao() {
        return m_dao;
    }
}
