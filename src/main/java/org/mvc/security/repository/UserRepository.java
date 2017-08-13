package org.mvc.security.repository;

import java.util.List;

import org.mvc.security.entity.User;

public interface UserRepository extends BaseSecurityRepository<User>{
	 public User findUserByUsername(String username);
	 public List<User> getAllUserWithOutSuperAdminRole();
}
