package com.chengziting.razor.dao.base;

import com.chengziting.razor.model.persistent.BaseModel;
import com.chengziting.razor.model.system.PagingModel;
import org.hibernate.criterion.Criterion;

import java.util.List;

/**
 * Created by user on 2018-01-05.
 */
public interface IBaseDao<TEntity extends BaseModel,TId> {
    List<TEntity> getList();
    String save(TEntity var1);

    boolean save(List<TEntity> var1);

    boolean delete(TEntity var1);
    boolean delete(TId id);

    boolean delete(List<TEntity> var1);

    boolean update(TEntity var1, TEntity var2);
    PagingModel getList(int startIndex, int pagingSize, Criterion[] filter);
}
