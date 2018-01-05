package com.chengziting.razor.dao.base;

import com.chengziting.razor.model.persistent.BaseModel;
import com.chengziting.razor.model.system.PagingModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by user on 2018-01-05.
 */
@Transactional
public abstract class BaseDao<TEntity extends BaseModel,TId> implements IBaseDao<TEntity,TId>{
    private HibernateTemplate hibernateTemplate;
    private JdbcTemplate      jdbcTemplate;

    @Autowired
    public void setHibernateTemplate(HibernateTemplate template){
        this.hibernateTemplate = template;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate template){
        this.jdbcTemplate = template;
    }

    public HibernateTemplate getHibernateTemplate(){
        return hibernateTemplate;
    }
    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    protected Class<TEntity> getEntityType(){
        Class<TEntity> type = (Class<TEntity>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return type;
    }

    protected synchronized Session getSession(){
        return getHibernateTemplate().getSessionFactory().getCurrentSession();
    }

    public List<TEntity> getList() {
        Class<TEntity> type = getEntityType();
        System.out.println(type.getName());
        return getHibernateTemplate().loadAll(type);
    }

    public String save(TEntity var1) {
        return null;
    }

    public boolean save(List<TEntity> var1) {
        return false;
    }

    public boolean delete(TEntity var1) {
        return false;
    }

    public boolean delete(TId id) {
        Session session = getSession();
        TEntity entity = session.load(getEntityType(), (Serializable) id);
        session.delete(entity);
        return true;
    }

    public boolean delete(List<TEntity> var1) {
        return false;
    }

    public boolean update(TEntity var1, TEntity var2) {
        return false;
    }

    public PagingModel getList(int startIndex, int pagingSize, Criterion[] filter) {
        PagingModel pagingModel = new PagingModel();

        Session session = getSession();
        Criteria criteria = session.createCriteria(getEntityType());
        for(Criterion c : filter){
            criteria.add(c);
        }

        long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection(null);
        criteria.setFirstResult(startIndex);
        criteria.setMaxResults(startIndex + pagingSize);
        List<TEntity> list = criteria.list();
        pagingModel.setData(list);
        pagingModel.setTotalCount(totalCount);
        pagingModel.setCurrentPage((long) Math.ceil(startIndex/pagingSize));
        return pagingModel;
    }
}
