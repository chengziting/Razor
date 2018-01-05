package com.chengziting.razor.service.base;

import com.chengziting.razor.dao.base.BaseDao;
import com.chengziting.razor.model.persistent.BaseModel;

/**
 * Created by user on 2018-01-05.
 */
public interface IBaseService<TEntity extends BaseModel,TDao extends BaseDao<TEntity,TId>,TId> {
}
