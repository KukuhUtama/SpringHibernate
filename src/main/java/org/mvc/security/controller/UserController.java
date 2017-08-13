package org.mvc.security.controller;

import java.util.Collection;
import java.util.List;

import org.mvc.security.entity.Role;
import org.mvc.security.entity.User;
import org.mvc.security.service.UserService;
import org.mvc.security.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	private String roles;
	private User user;
	private List<User> users;
	private org.springframework.security.core.userdetails.User authUser;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		String message = "Hello There";
		return new ModelAndView("welcome", "message", message);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String showUserRegistration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String saveUserRegistration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userService.add(user);
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/admin/listuser", method = RequestMethod.GET)
	public String listUser(Model model) {
		authUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Collection<? extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		for (int i = 0; i < granted.size(); i++) {
			roles = granted.toArray()[i] + "";
		}
		users = userService.getAllUserWithOutSuperAdminRole();
		model.addAttribute("user", authUser.getUsername());
		model.addAttribute("roles", roles);
		model.addAttribute("users", users);
		return "admin/listuser";
	}
}
