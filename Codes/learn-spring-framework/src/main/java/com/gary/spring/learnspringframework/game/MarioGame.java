package com.gary.spring.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole{
	public void up() {
		System.out.println("jump");
	}
	public void down() {
		System.out.println("donw into a hole");
	}
	public void left() {
		System.out.println("left");
	}
	public void right() {
		System.out.println("right");
	}
}
