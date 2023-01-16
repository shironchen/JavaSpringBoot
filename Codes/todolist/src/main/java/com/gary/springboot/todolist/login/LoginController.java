package com.gary.springboot.todolist.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

// login -> com.gary.springboot.todolist.login.LoginController -> login.jsp
@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	// http://localhost:8080/login?name=gary
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String goToWelcomePage(
			@RequestParam String name,
			@RequestParam String password,
			ModelMap model) {

		if(authenticationService.authenticate(name, password)) {
			model.put("name", name);

			// Authentication
			// name: gary, password: password
			
			return "welcome";
		}
		
		
		model.put("errorMessage", "Invalid Credentials, Plz try again.");
		return "login";
		
	}
	
}
