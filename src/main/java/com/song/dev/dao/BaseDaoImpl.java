package com.song.dev.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("baseDao")
public class BaseDaoImpl <T> implements BaseDao<T>{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	  
	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public T getById(Class<T> c, Serializable id){
		return (T) this.getCurrentSession().get(c, id);
	}
	public Serializable save(T o){
		return this.getCurrentSession().save(o);
	}
	public void saveOrUpdate(T o){
		this.getCurrentSession().saveOrUpdate(o);
	}
	
	@Override
	public T getUniqueByProperties(Class<T> c, String[] properties, String[] values) {
		String queryString = createHql(c, properties, values);
		Query query = this.getCurrentSession().createQuery(queryString, c).setMaxResults(1);
		List<T> result = query.list();
		return CollectionUtils.isEmpty(result) ? null : result.get(0);
	}
	
	public String createHql(Class<T> c, String[] properties, Object[] values){
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(c.getName()).append(" as model where ");
		for (int i = 0; i < properties.length; i++) {
			sb.append("model.").append(properties[i]).append("='").append(values[i]).append("' and ");
		}
		return properties.length>0 ? sb.substring(0, sb.length()-5) : sb.toString();
	}
	/*
	public void delete(T o){
		this.getCurrentSession().delete(o);
	}
	public void update(T o){
		this.getCurrentSession().update(o);
	};
	public List<T> findByHql(String hql){
		return this.getCurrentSession().createQuery(hql).list();
	}
	public List<T> findByHql(String hql, Object[] param){
		Query q = this.getCurrentSession().createQuery(hql);
		if(param != null && param.length > 0){
			for(int i=0; i<param.length; i++){
				q.setParameter(i, param[i]);
			}
		}
		return q.list();
	}
	public List<T> findByHql(String hql, List<Object> param){
		Query q = this.getCurrentSession().createQuery(hql);
		if(param != null && param.size() > 0){
			for(int i=0; i<param.size(); i++){
				q.setParameter(i, param.get(i));
			}
		}
		return q.list();
	}
	public List<T> findByHql(String hql, List<Object> param, Integer page, Integer rows){
		if(page == null || page<1){
			page = 1;
		}
		if(rows == null || rows<1){
			rows = 1;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		if(param != null && param.size() > 0){
			for(int i=0 ; i<param.size(); i++){
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1)*rows).setMaxResults(rows).list();
	}
	
	public T get(String hql, Object[] param);
	public T get(String hql, List<Object> param);
	public Long countByHql(String hql);
	public Integer executeHql(String hql);
	public Integer executeHql(String hql, List<Object> param);
	public Integer executeHql(String hql, Object[] param);*/

	
}
