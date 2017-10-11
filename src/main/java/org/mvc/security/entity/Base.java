package org.mvc.security.entity;

import javax.persistence.Transient;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

public class Base<T> {
	@Transient
	protected String[] ignoredList = new String[] {};

	public Base() {
		ignoredList = new String[] {};
	}

	public void fromDomain(T domain) {
		fromDomain(domain, false);
	}

	public void fromDomain(T domain, boolean include) {
		if (domain != null) {
			BeanUtils.copyProperties(domain, this, ignoredList);
		}
	}

	public T toDomain(Class<T> clazz) {
		T result = null;
		return null;
	}

	public T toDomain(Class<T> clazz, boolean include) {
		T result = null;
		try {
			result = clazz.newInstance();
			BeanUtils.copyProperties(this, result, ignoredList);
		} catch (InstantiationException | IllegalAccessException | BeansException e) {
			System.out.println("error: " + e.getMessage());
		}
		return null;

	}
}
