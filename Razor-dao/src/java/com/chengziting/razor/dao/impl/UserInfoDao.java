package com.chengziting.razor.dao.impl;

import com.chengziting.razor.core.exception.ServiceException;
import com.chengziting.razor.dao.IUserInfoDao;
import com.chengziting.razor.dao.base.BaseDao;
import com.chengziting.razor.model.persistent.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by user on 2018-01-16.
 */
@Repository
@Transactional
public class UserInfoDao extends BaseDao<UserInfo,String> implements IUserInfoDao {
}
