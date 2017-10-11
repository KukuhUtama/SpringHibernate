package org.mvc.security.repository;

public interface BaseSecurityRepository <E> {
	public void add(E e);
	public E findById(long id);
	public void update(E e);
}
