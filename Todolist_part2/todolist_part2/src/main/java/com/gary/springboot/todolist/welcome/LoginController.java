package com.gary.springboot.todolist.welcome;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private AuthService authService;
	
	public LoginController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		
		model.put("name", name);
		System.out.println("Request param is " + name);
		return "login";
	}

	@RequestMapping(value="login",method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, 
			@RequestParam String password, ModelMap model) {
		
		if(authService.check(name, password)) {
		
			model.put("name", name);
			return "welcome";
		}
		return "login";
	}
}