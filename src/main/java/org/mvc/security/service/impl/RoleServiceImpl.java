package org.mvc.security.service.impl;

import org.mvc.security.entity.Role;
import org.mvc.security.repository.RoleRepository;
import org.mvc.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {

	@Autowired
	public RoleRepository roleRepository;
	
	@Override
	public void add(Role role) {
		roleRepository.add(role);
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findById(id);
	}

	@Override
	public void delete(Role role) {
		roleRepository.delete(role);
	}

}
