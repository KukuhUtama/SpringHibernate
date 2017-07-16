package org.mvc.security.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.mvc.security.repository.BaseSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseSecurityRepositoryImpl<E> implements BaseSecurityRepository<E> {

	@Autowired
    SessionFactory sessionFactory;
	private Class<E> entity;
	private Criteria criteria;

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
		System.out.println(e);
		getCurrentSession().saveOrUpdate(e);
		//getCurrentSession().persist(e);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public E findByName(String name) {
		criteria = getCurrentSession().createCriteria(entity.getClass());
		criteria.add(Restrictions.eq("username", name).ignoreCase());
		return (E) criteria.uniqueResult();
	}
}
