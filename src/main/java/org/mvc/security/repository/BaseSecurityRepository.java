package org.mvc.security.repository;

public interface BaseSecurityRepository <E> {
	void add(E e);
	E findByName(String name);
}
