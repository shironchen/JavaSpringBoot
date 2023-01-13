package com.gary.springboot.todolist.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// login -> com.gary.springboot.todolist.login.LoginController -> login.jsp
@Controller
public class LoginController {
	
	// http://localhost:8080/login?name=gary
	@RequestMapping("/login")
	public String goToLoginPage() {

		return "login";
	}
	
	
	
}
