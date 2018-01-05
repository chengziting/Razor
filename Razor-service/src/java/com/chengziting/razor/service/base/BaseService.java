package com.chengziting.razor.service.base;


import com.chengziting.razor.dao.base.BaseDao;
import com.chengziting.razor.model.persistent.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by user on 2018-01-05.
 */
public class BaseService<TEntity extends BaseModel,TDao extends BaseDao<TEntity,TId>,TId> implements IBaseService<TEntity,TDao,TId> {
    @Autowired
    protected TDao m_dao;
    protected TDao getDao(){
        return m_dao;
    }
}
