package org.mvc.security.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mvc.security.entity.Role;
import org.mvc.security.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

	@Autowired
	protected SessionFactory sessionFactory;
	private Class<T> entity;
	protected Query query;

	public BaseRepositoryImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		entity = (Class) pt.getActualTypeArguments()[0];
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		sessionFactory = sessionFactory;
	}

	protected Session getCurrentSession() {
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}
	}

	public void add(T entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	
	@SuppressWarnings("unchecked")
	public T findById(long id) {
		return (T) sessionFactory.getCurrentSession().get(entity.getName(), id);
	}

	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return (List<T>)sessionFactory.getCurrentSession().createQuery("select a from "+entity.getName()+ " a").getResultList();
	}

	@SuppressWarnings("unchecked")
	public void deleteById(long id) {
		T bean = (T) getCurrentSession().load(entity.getName(), id);
		if (null != bean) {
			sessionFactory.getCurrentSession().delete(bean);
		}

	}
}
