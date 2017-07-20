package org.mvc.security.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.mvc.security.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> entity;
	private Criteria criteria;

	public BaseRepositoryImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entity = (Class) pt.getActualTypeArguments()[0];
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}

	public void add(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public T findById(int id) {
		return (T) getCurrentSession().get(entity.getName(), id);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}
	
	public T findByName(String name){
		criteria = getCurrentSession().createCriteria(entity.getClass());
		criteria.add(Restrictions.eq("name", name).ignoreCase());
		return (T) criteria.uniqueResult();
	}
}
