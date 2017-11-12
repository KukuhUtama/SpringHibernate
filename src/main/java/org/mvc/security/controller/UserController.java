package org.mvc.security.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mvc.security.entity.Role;
import org.mvc.security.entity.User;
import org.mvc.security.service.RoleService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserValidator userValidator;
	private String roles;
	private List<User> users;
	private List<String> grantedRoleNames;
	private List<Role> ungrantedRoles;
	private org.springframework.security.core.userdetails.User authUser;
	private User user;

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
		System.out.println(users.get(0).getRoles().size());
		return "admin/listuser";
	}
	

	
	@RequestMapping(value = "/admin/detailuser", method = RequestMethod.GET)
	public String detailUser(@RequestParam(value="id", required=true) long id, @RequestParam(value="isRevoke", required=false) boolean isRevoke, @RequestParam(value="isGrant", required=false) boolean isGrant, Model model){
		user = userService.findUserById(id);
		if(isRevoke == false && isGrant == true){
			grantedRoleNames = new ArrayList<String>();
			for(Role role : user.getRoles() ){
				grantedRoleNames.add(role.getName());
			}
			ungrantedRoles = roleService.findUngrantedRole(grantedRoleNames);
			model.addAttribute("ungrantedroles", ungrantedRoles);
			model.addAttribute("isGrant", true);
		} 
		if(isRevoke == true && isGrant == false){
			model.addAttribute("isRevoke", true);
		} 
		model.addAttribute("user", user);
		return "admin/detailuser";
	}
	
	@RequestMapping(value="/admin/revokeuserrole", method= RequestMethod.POST)
	public String revokeUserRole(@ModelAttribute("user")User user){
		userService.update(user);
		return "redirect:/admin/detailuser?id="+user.getId()+"&isRevoke="+true+"&isGrant="+false;
	}
}
