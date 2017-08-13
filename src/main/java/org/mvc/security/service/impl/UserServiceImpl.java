package org.mvc.security.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.mvc.security.entity.User;
import org.mvc.security.repository.UserRepository;
import org.mvc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
		System.out.println("user name"+user.getUsername());
		System.out.println("In find byname servie");
		return user;
	}

	@Override
	public List<User> getAllUserWithOutSuperAdminRole() {
		return userRepository.getAllUserWithOutSuperAdminRole();
	}

}
