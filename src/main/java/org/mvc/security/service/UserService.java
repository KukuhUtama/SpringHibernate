package org.mvc.security.service;

import java.util.List;

import org.mvc.security.entity.User;

public interface UserService {
	void add(User user);
	User findByName(String name);
	List<User> getAllUserWithOutSuperAdminRole();
}
