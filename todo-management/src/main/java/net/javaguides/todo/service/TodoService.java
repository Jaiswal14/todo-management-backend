package net.javaguides.todo.service;

import java.util.List;

import net.javaguides.todo.dto.TodoDto;

public interface TodoService {
	
	TodoDto addTodo(TodoDto todoDto);
	
	TodoDto getTodo(Long id);
	
	List<TodoDto> getAllTodos();
	
	TodoDto updateTodo(Long id, TodoDto todoDto);
	
	void deleteTodo(Long id);
	
	TodoDto completeTodo(Long id);
	
	TodoDto inCompleteTodo(Long id);
}
