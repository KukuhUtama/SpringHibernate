package org.mvc.security.service.impl;

import java.util.List;

import org.mvc.security.entity.User;
import org.mvc.security.repository.UserRepository;
import org.mvc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;

	@Override
	public void add(User user) {
		System.out.println("Add user");
		userRepository.add(user);
	}

	@Override
	public User findByName(String username) {
		User user = userRepository.findUserByUsername(username);
		return user;
	}

	@Override
	public List<User> getAllUserWithOutSuperAdminRole() {
		return userRepository.getAllUserWithOutSuperAdminRole();
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void update(User user) {
		userRepository.update(user);
	}

}
