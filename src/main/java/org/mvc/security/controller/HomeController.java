package org.mvc.security.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mvc.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private User authUser;
	private String roles;

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Collection<? extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		for (int i = 0; i < granted.size(); i++) {
			roles = granted.toArray()[i] + "";
		}
		model.addAttribute("user", authUser.getUsername());
		model.addAttribute("roles", roles);
		return "admin";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String user(Model model) {
		authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Collection<? extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		for (int i = 0; i < granted.size(); i++) {
			roles = granted.toArray()[i] + "";
		}
		model.addAttribute("user", authUser.getUsername());
		model.addAttribute("roles", roles);
		return "home";
	}
	
	@RequestMapping(value="/moderator", method = RequestMethod.GET)
	public String moderator(Model model){
		authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Collection<? extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		for (int i = 0; i < granted.size(); i++) {
			roles = granted.toArray()[i] + "";
		}
		model.addAttribute("user", authUser.getUsername());
		model.addAttribute("roles", roles);
		return "moderator";
	}

}
