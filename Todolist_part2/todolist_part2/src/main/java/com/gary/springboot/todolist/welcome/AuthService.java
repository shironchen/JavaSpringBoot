package com.gary.springboot.todolist.welcome;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
	
	public boolean check(String username, String password) {
		
		boolean isValidName = username.equalsIgnoreCase("gary");
		boolean isValidPassword = password.equalsIgnoreCase("1234567890");
		
		return isValidName && isValidPassword;
	}
}