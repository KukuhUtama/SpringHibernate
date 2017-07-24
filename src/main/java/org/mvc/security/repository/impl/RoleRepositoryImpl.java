package org.mvc.security.repository.impl;

import java.util.List;

import org.mvc.security.entity.Role;
import org.mvc.security.repository.RoleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl extends BaseRepositoryImpl<Role> implements RoleRepository{

	@Override
	public Role findRoleByName(String name) {
		query = getCurrentSession().createQuery("select u FROM User u where u.username= :username");
        query.setParameter("name", name);
        List<Role> roles = query.getResultList();
        if (roles  != null && roles .size() == 1) {
            return roles.get(0);
        }
       return null;
	}

}
