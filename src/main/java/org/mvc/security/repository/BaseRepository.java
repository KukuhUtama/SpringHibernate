package org.mvc.security.repository;

import java.util.List;

public interface BaseRepository <T> {
	public void add(T entity);
	public T findById(long id);
	public void delete(T entity);
	public List<T> getAll();
	public void deleteById(long id);
}
