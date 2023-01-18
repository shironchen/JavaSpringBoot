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
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount, "gary", "Learn Spring Boot",
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "gary", "Learn JSP",
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "gary", "Learn Math",
				LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsername(String username) {
		return todos;
	}
	
	public void addToDo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteTodoById(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		
		deleteTodoById(todo.getId());
		todos.add(todo);
		
	}
	
}
