package com.gary.springboot.todolist.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class SayHelloController {
	
	//"say-hello" => "Hello!"
	// http://localhost:8080/say-hello
	@RequestMapping("/say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello!";
	}
}
