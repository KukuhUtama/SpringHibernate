package org.mvc.security.repository.impl;

import org.mvc.security.entity.User;
import org.mvc.security.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseSecurityRepositoryImpl<User> implements UserRepository {

}
