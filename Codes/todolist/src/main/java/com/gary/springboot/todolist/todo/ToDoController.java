package com.gary.springboot.todolist.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {

	public ToDoController(com.gary.springboot.todolist.todo.ToDoService toDoService) {
		super();
		ToDoService = toDoService;
	}

	private ToDoService ToDoService;
	

	@RequestMapping("list-todos")
	public String listAllToDos(ModelMap model) {
		
		List<ToDo> todos = ToDoService.findByUsername("gary");
		model.addAttribute("todos", todos);
		
		return "listToDos";
	}
	
}
