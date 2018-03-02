package com.chengziting.razor.service.base;


import com.chengziting.razor.dao.base.BaseDao;
import com.chengziting.razor.dao.base.IBaseDao;
import com.chengziting.razor.model.persistent.BaseModel;
import com.chengziting.razor.model.system.PagingModel;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018-01-05.
 */
public abstract class BaseService<TEntity extends BaseModel,TId> implements IBaseService<TEntity,TId> {
    protected abstract IBaseDao<TEntity,TId> getDao();

    public TEntity get(TId tId) {
        return (TEntity) getDao().get(tId);
    }

    public TEntity getFirst(Map<String, Object> condition) {
        return getDao().getFirst(condition);
    }

    public List<TEntity> getList() {
        return getDao().getList();
    }

    public TId save(TEntity var1) {
        return getDao().save(var1);
    }

    public boolean save(List<TEntity> var1) {
        return getDao().save(var1);
    }

    public boolean delete(TEntity var1) {
        return getDao().delete(var1);
    }

    public boolean delete(TId tId) {
        return getDao().delete(tId);
    }

    public boolean delete(List<TEntity> var1) {
        return getDao().delete(var1);
    }

    public boolean update(TEntity var1, TEntity var2) {
        return getDao().update(var1,var2);
    }

    public PagingModel getList(int startIndex, int pagingSize, Criterion[] filter) {
        return getDao().getList(startIndex,pagingSize,filter);
    }
}
