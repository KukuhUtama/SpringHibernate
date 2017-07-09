package org.mvc.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public ModelAndView helloWorld() {
 
		String message = "Hello There";
		return new ModelAndView("welcome", "message", message);
	}
	
	/*@RequestMapping(value="/registration",method=RequestMethod.GET)
	public String registration() {
		return "registration";
	}
*/
}
