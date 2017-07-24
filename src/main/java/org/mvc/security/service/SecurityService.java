package org.mvc.security.service;

public interface SecurityService {
	public String findLoggedInUsername();
	public void autoLogIn(String username, String password);
}
