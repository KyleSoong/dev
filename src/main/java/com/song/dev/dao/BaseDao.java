package com.song.dev.dao;

import java.io.Serializable;

public interface BaseDao<T> {
	public T getById(Class<T> c, Serializable id);
	public Serializable save(T o);
	public void saveOrUpdate(T o);
	public T getUniqueByProperties(Class<T> c, String[] properties, String[] values);
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
