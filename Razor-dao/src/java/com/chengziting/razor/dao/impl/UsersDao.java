package com.chengziting.razor.dao.impl;

import com.chengziting.razor.dao.IUsersDao;
import com.chengziting.razor.dao.base.BaseDao;
import com.chengziting.razor.model.persistent.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by user on 2018-01-16.
 */
@Repository
@Transactional
public class UsersDao extends BaseDao<Users,String> implements IUsersDao {
}
