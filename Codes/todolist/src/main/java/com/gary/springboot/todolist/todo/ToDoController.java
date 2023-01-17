package com.gary.springboot.todolist.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
		
		List<ToDo> todos = toDoService.findByUsername("gary");
		model.addAttribute("todos", todos);
		
		return "listToDos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewToDoPage() {
		
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewToDo(@RequestParam String description, ModelMap model) {
		String username = (String)model.get("name");
		toDoService.addToDo(username, description, 
				LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
	}
	
}
