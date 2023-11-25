package com.ToDo.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ToDo.app.Repository.TodoRepository;
import com.ToDo.app.entity.Todo;
import com.ToDo.app.service.TodoService;


@Service
public class TodoServiceImpl implements TodoService{
	private TodoRepository todoRepository;
		
	public TodoServiceImpl(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@Override
	public List<Todo> getAllTasks() {
		return todoRepository.findAll();
	}

	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo getTodoById(Long id) {
		return todoRepository.findById(id).get();
	}

	@Override
	public Todo updateTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public void deleteTodoById(Long id) {
		todoRepository.deleteById(id);
	}
	
}
