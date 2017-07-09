package org.mvc.security.service;

import org.mvc.security.entity.User;

public interface UserService {
	void add(User user);
	User findByName(String name);
}
