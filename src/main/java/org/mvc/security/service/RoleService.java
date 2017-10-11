package org.mvc.security.service;

import java.util.List;

import org.mvc.security.entity.Role;

public interface RoleService {
	public void add(Role role);
	public Role findById(int id);
	public void delete(Role role);
	public Role findByName(String name);
	public List<Role> getAllRole();
	public void deleteById(long id);
	public List<Role> findUngrantedRole(List<String> grantedRoleName);
}
