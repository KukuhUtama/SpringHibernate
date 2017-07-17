package org.mvc.security.controller;

import org.mvc.security.entity.Role;
import org.mvc.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoleController {
	
   @Autowired
   RoleService roleService;
   
   @RequestMapping(value="/showaddrole", method=RequestMethod.GET)
   public String showAddRole(Model model){
	   model.addAttribute("role", new Role());
	   return "AddRole";
   }
   
   @RequestMapping(value="/addrole", method=RequestMethod.POST)
   public String addRole(@ModelAttribute("role")Role role, BindingResult bindingResult, Model model){
	   roleService.add(role);
	   return "welcome";
   }
}