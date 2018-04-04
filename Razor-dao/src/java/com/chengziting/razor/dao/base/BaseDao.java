package com.chengziting.razor.dao.base;

import com.chengziting.razor.core.SpringContextUtils;
import com.chengziting.razor.core.exception.ServiceException;
import com.chengziting.razor.model.persistent.BaseModel;
import com.chengziting.razor.model.system.PagingModel;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2018-01-05.
 */
@Transactional
@Repository
public abstract class BaseDao<TEntity extends BaseModel,TId> implements IBaseDao<TEntity,TId>{
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private JdbcTemplate      jdbcTemplate;

    private static Logger logger ;

    public BaseDao(){
        logger = Logger.getLogger(this.getClass());
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

    protected Session getSession(){
        Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
        
        return session;
    }

    public TEntity get(TId tId) {
        Class<TEntity> type = getEntityType();
        return getSession().get(type,(Serializable)tId);
    }

    public TEntity getFirst(Map<String, Object> condition) {
        Session session = getSession();
//        try {
        Class<TEntity> type = getEntityType();
        Criteria criteria = session.createCriteria(type);
        for (String key : condition.keySet()) {
            Object value = condition.get(key);
            criteria.add(Restrictions.eq(key, value));
        }
        List list = criteria.list();
        if(list.size() > 0){
            return (TEntity)list.get(0);
        }
        return null;
//        } finally {
//            session.close();
//        }
    }

    public List<TEntity> getList() {
        Class<TEntity> type = getEntityType();
        System.out.println(type.getName());
        return getHibernateTemplate().loadAll(type);
    }

    public TId save(TEntity var1) {
        Session session = getSession();
        logger.info("session hashCode="+session.hashCode());
        TId id = (TId) session.save(var1);
        return id;
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

    public void saveOrUpdate(TEntity entity){
        Session session = null;
        try{
            //entity.setUpdateDate(new Date());
            session = getSession();
            session.saveOrUpdate(entity);
        }finally {
            System.out.println("Session connection status:"+session.isConnected());
        }
    }

    public PagingModel getList(int startIndex, int pagingSize, Criterion[] filter) {
        PagingModel pagingModel = new PagingModel();

        Session session = getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        Criteria criteria = session.createCriteria(getEntityType());

        for(Criterion c : filter){
            criteria.add(c);
        }

        criteria.add(Restrictions.eq("",""));

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
