package com.gary.springboot.todolist.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
public class TodoController {

	public TodoController(com.gary.springboot.todolist.todo.TodoService TodoService) {
		super();
		todoService = TodoService;
	}

	private TodoService todoService;
	

	@RequestMapping(value="list-todos", method=RequestMethod.GET)
	public String listAllToDos(ModelMap model) {
		
		List<Todo> todos = todoService.getTodos();
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		
		Todo todo = new Todo(0, "New Task", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewToDo(ModelMap model, @Validated Todo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "addTodo";
		}
		todoService.add(todo.getDescription(), 
				todo.getTargetDate(), todo.isDone());
		
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		
		Todo todo = todoService.find(id);
		model.addAttribute("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoService.delete(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "addTodo";
		}
		todoService.update(todo);
		return "redirect:list-todos";
	}

}
