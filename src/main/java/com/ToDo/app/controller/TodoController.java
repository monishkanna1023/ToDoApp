package com.ToDo.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ToDo.app.entity.Todo;
import com.ToDo.app.service.TodoService;

@Controller
public class TodoController {
	private TodoService todoService;
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	@GetMapping("/todos")
	public String listTodo(Model model) {
		model.addAttribute("todos", todoService.getAllTasks());
		return "todo_home";
	}

	@GetMapping("todos/new")
	public String createTodoForm(Model model){
		Todo todo = new Todo();
		model.addAttribute("todo", todo);
		return "create_todo";
	}

	@PostMapping("/todos")
	public String saveTodo(@ModelAttribute("todo") Todo todo){
		todoService.saveTodo(todo);
		return "redirect:/todos";
	}

	@GetMapping("/todos/edit/{id}")
	public String editTodo(@PathVariable Long id, Model model){
		model.addAttribute("todo", todoService.getTodoById(id));
		return "edit_todo";
	}

	@PostMapping("/todos/{id}")
	public String updateTodo(@PathVariable Long id, @ModelAttribute("todo") Todo todo, Model model){
		Todo existingTodo = todoService.getTodoById(id);
		existingTodo.setId(id);
		existingTodo.setStatus(todo.getStatus());

		todoService.updateTodo(existingTodo);
		return "redirect:/todos";
	}

	@GetMapping("todos/{id}")
	public String deleteTodo(@PathVariable Long  id){
		todoService.deleteTodoById(id);
		return "redirect:/todos";
	}
}
