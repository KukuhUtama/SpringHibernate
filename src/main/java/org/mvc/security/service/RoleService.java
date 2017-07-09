package org.mvc.security.service;

import org.mvc.security.entity.Role;

public interface RoleService {
	public void add(Role role);
	public Role findById(int id);
	public void delete(Role role);
}
