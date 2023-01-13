package com.gary.springboot.todolist.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class SayHelloController {
	
	//"say-hello" => "Hello!"
	// http://localhost:8080/say-hello
	@RequestMapping("/hello-string")
	@ResponseBody
	public String sayHelloString() {
		return "Hello String!";
	}
	
	// http://localhost:8080/say-hello-jsp
	// /src/main/resources/META_INF/resources/WEB-INF/jsp/sayHello.jsp
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJSP(@RequestParam String name, ModelMap model) {
		
		model.put("name", name);
		
		Logger logger = LoggerFactory.getLogger(getClass());
		
		// loging level: debug < info < warn
		logger.debug("I want this print at debug level.");
		logger.info("I want this print at info level.");
		logger.warn("I want this print at warn level.");
		
		logger.debug("Request Param(name) is {}", name);
		System.out.println("Request Param(name) is " + name);
		
		return "sayHello"; // "ViewResolver": "Should be same as the filename in jsp view, will add this string after prefix and before suffix in application.properties
		
	}
}

