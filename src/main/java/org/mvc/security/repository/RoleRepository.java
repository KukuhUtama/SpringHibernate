package org.mvc.security.repository;

import org.mvc.security.entity.Role;

public interface RoleRepository extends BaseRepository<Role>{
   public Role findRoleByName(String name);
}
