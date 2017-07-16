package org.mvc.security.service.impl;

import javax.transaction.Transactional;

import org.mvc.security.entity.User;
import org.mvc.security.repository.UserRepository;
import org.mvc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;
	
	@Override
	public void add(User user) {
		userRepository.add(user);
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

}
