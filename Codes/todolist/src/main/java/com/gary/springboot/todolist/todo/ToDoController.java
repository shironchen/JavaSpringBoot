package com.gary.springboot.todolist.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ToDoController {

	public ToDoController(com.gary.springboot.todolist.todo.ToDoService ToDoService) {
		super();
		toDoService = ToDoService;
	}

	private ToDoService toDoService;
	

	@RequestMapping("list-todos")
	public String listAllToDos(ModelMap model) {
		
		List<Todo> todos = toDoService.findByUsername("gary");
		model.addAttribute("todos", todos);
		
		return "listToDos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewToDoPage(ModelMap model) {
		
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "Default Description", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewToDo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if (result.hasErrors()) {
			return "todo";
		}
		
		String username = (String)model.get("name");
		toDoService.addToDo(username, todo.getDescription(), 
				LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
	}
	
}
