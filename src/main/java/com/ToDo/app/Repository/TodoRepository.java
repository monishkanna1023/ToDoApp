package com.ToDo.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDo.app.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	
}
