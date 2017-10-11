package org.mvc.security.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mvc.security.repository.BaseSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseSecurityRepositoryImpl<E> implements BaseSecurityRepository<E> {

	@Autowired
	SessionFactory sessionFactory;
	private Class<E> entity;
	protected Query query;
	protected CriteriaBuilder builder;
	protected CriteriaQuery<E> criteria;

	public BaseSecurityRepositoryImpl() {
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

	public void add(E e) {
		getCurrentSession().saveOrUpdate(e);
	}

	public void update(E e) {
		getCurrentSession().update(e);
	}

	public E findById(long id) {
		return (E) getCurrentSession().get(entity.getName(), id);
	}

}