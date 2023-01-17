package com.gary.springboot.todolist.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	private static List<ToDo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new ToDo(++todosCount, "gary", "Learn Spring Boot",
				LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(++todosCount, "gary", "Learn JSP",
				LocalDate.now().plusYears(2), false));
		todos.add(new ToDo(++todosCount, "gary", "Learn Math",
				LocalDate.now().plusYears(3), false));
	}
	
	public List<ToDo> findByUsername(String username) {
		return todos;
	}
	
	public void addToDo(String username, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
}
