package org.mvc.security.repository;

public interface BaseRepository <T> {
	public void add(T entity);
	public T findById(int id);
	public void delete(T entity);
	public T findByName(String name);
}
