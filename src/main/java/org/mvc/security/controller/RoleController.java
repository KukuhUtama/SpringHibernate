package org.mvc.security.controller;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mvc.security.entity.Role;
import org.mvc.security.service.RoleService;
import org.mvc.security.validator.RoleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoleController {
	private User authUser;
	private String roles;
	private Map<String, String> listRole;
	private List<Role> listRoleUser;
	
	@Autowired
	RoleService roleService;
	@Autowired
	RoleValidator roleValidator;

	@RequestMapping(value = "/admin/addrole", method = RequestMethod.POST)
	public String addRole(@ModelAttribute("role") Role role, BindingResult bindingResult, Model model) {
		roleValidator.validate(role, bindingResult);
		if (bindingResult.hasErrors()) {
			listRole = new LinkedHashMap<String, String>();
			listRole.put("USER", "User");
			listRole.put("MODERATOR", "Moderator");
			model.addAttribute("listRole", listRole);
			return "admin/addrole";
		}
		roleService.add(role);
		return "redirect:/admin/listrole";
	}

	@RequestMapping(value = "/admin/addrole", method = RequestMethod.GET)
	public String showAddRole(Model model) {
		authUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Collection<? extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		for (int i = 0; i < granted.size(); i++) {
			roles = granted.toArray()[i] + "";
		}
		listRole = new LinkedHashMap<String, String>();
		listRole.put("USER", "User");
		listRole.put("MODERATOR", "Moderator");

		model.addAttribute("user", authUser.getUsername());
		model.addAttribute("roles", roles);
		model.addAttribute("listRole", listRole);
		model.addAttribute("role", new Role());
		return "admin/addrole";
	}

	@RequestMapping(value = "/admin/listrole", method = RequestMethod.GET)
	public String listRole(Model model) {
		authUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Collection<? extends GrantedAuthority> granted = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		for (int i = 0; i < granted.size(); i++) {
			roles = granted.toArray()[i] + "";
		}
	    listRoleUser = roleService.getAllRole();
		model.addAttribute("user", authUser.getUsername());
		model.addAttribute("roles", roles);
		model.addAttribute("listRoleUser",listRoleUser);

		return "admin/listrole";
	}
	
	@RequestMapping(value="/admin/deleterole", method=RequestMethod.GET)
	public String deleteRole(@RequestParam(value="id", required= true)int id){
		roleService.deleteById(id);
		return "redirect:/admin/listrole";
	}
}
