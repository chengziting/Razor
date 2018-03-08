package com.chengziting.razor.dao.impl;

import com.chengziting.razor.dao.IUserRoleDao;
import com.chengziting.razor.dao.base.BaseDao;
import com.chengziting.razor.model.persistent.UserRole;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 2018-03-06.
 */
@Repository
public class UserRoleDao extends BaseDao<UserRole,String > implements IUserRoleDao {
}
