package org.mvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		System.out.println("in login"+model);
		System.out.println("in error"+error);
		System.out.println("in login"+logout);
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");
		return "login";
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {
		System.out.println("index method");
		return "index";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		System.out.println("index method");
		return "admin";
	}

}
