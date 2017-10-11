package org.mvc.security.repository.impl;

import java.util.List;

import org.mvc.security.entity.Role;
import org.mvc.security.repository.RoleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl extends BaseRepositoryImpl<Role> implements RoleRepository{

	@SuppressWarnings("unchecked")
	@Override
	public Role findRoleByName(String name) {
		query = sessionFactory.getCurrentSession().createQuery("FROM Role r WHERE r.name = :name");
        query.setParameter("name", name);
        List<Role> roles = query.getResultList();
        if (roles  != null && roles .size() >= 1) {
            return roles.get(0);
        }
       return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findUngrantedRole(List<String> grantedRoleName) {
		query = sessionFactory.getCurrentSession().createQuery("FROM Role r WHERE r.name NOT IN (:names)")
				.setParameterList("names", grantedRoleName);
		return  query.getResultList();
	}



}
