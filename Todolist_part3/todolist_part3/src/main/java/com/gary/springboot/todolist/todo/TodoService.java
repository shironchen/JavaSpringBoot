package com.gary.springboot.todolist.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	
	public List<Todo> getTodos() {
		return todos;
	}
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "Learn Spring Boot",
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Learn JSP",
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "Learn Math",
				LocalDate.now().plusYears(3), false));
	}
	
	public void add(String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, description, targetDate, done);
		todos.add(todo);
	}
	
	public void delete(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public Todo find(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void update(@Valid Todo todo) {
		
		delete(todo.getId());
		todos.add(todo);
		
	}
	
}
