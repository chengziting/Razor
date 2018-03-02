package com.chengziting.razor.dao.impl;

import com.chengziting.razor.dao.IRolesDao;
import com.chengziting.razor.dao.base.BaseDao;
import com.chengziting.razor.model.persistent.Roles;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 2018-01-05.
 */
@Repository
@Transactional
public class RolesDao extends BaseDao<Roles,String> implements IRolesDao {
}
