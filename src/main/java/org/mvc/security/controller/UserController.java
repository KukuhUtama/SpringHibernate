package org.mvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "Hello There";
		return new ModelAndView("welcome", "message", message);
	}

}
