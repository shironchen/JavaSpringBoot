package com.gary.spring.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.gary.spring.learnspringframework.enterprise.example.MyWebController;
import com.gary.spring.learnspringframework.game.GameRunner;

@SpringBootApplication
@ComponentScan("com.gary.spring.learnspringframework")
public class LearnSpringFrameworkApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);
		
//		GamingConsole game = new Mario();
//		GameRunner runner = new GameRunner(game);
		GameRunner runner = context.getBean(GameRunner.class);
		
		runner.run();
		
		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
