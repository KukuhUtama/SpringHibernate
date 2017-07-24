package org.mvc.security.repository;

import org.mvc.security.entity.User;

public interface UserRepository extends BaseSecurityRepository<User>{
	 public User findUserByUsername(String username);
}
