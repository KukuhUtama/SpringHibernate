package org.mvc.security.repository;

import java.util.List;

import org.mvc.security.entity.Role;

public interface RoleRepository extends BaseRepository<Role>{
   public Role findRoleByName(String name);
   public List<Role> findUngrantedRole(List<String> grantedRoleName);
}
