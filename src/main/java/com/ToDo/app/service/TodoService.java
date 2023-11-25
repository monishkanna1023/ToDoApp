package com.ToDo.app.service;

import java.util.List;

import com.ToDo.app.entity.Todo;

public interface TodoService {
	List<Todo> getAllTasks();
	Todo saveTodo(Todo todo);
	Todo getTodoById(Long id);
	Todo updateTodo(Todo todo);
	void deleteTodoById(Long id);
}
