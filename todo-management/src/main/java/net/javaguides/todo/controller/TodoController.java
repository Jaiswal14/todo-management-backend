package net.javaguides.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.todo.dto.TodoDto;
import net.javaguides.todo.service.TodoService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	// Build Add Todo Rest Api
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {

		TodoDto savedTodo = todoService.addTodo(todoDto);

		return new ResponseEntity<TodoDto>(savedTodo, HttpStatus.CREATED);
	}

	// Build Get Todo Rest Api
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping("{id}")
	public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {

		TodoDto todoDto = todoService.getTodo(todoId);

		return new ResponseEntity<TodoDto>(todoDto, HttpStatus.OK);
	}

	// Build Get All Todos Rest Api
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping
	public ResponseEntity<List<TodoDto>> getAllTodos() {

		List<TodoDto> allTodos = todoService.getAllTodos();

		return ResponseEntity.ok(allTodos);
	}

	// Build Update Todo Rest Api
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("{id}")
	public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long todoId, @RequestBody TodoDto todoDto) {

		TodoDto updatedTodo = todoService.updateTodo(todoId, todoDto);

		return ResponseEntity.ok(updatedTodo);
	}

	// Build Delete Todo Rest Api
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {

		todoService.deleteTodo(todoId);

		return ResponseEntity.ok("Todo deleted successfully!!!");
	}

	// Build Complete Todo Rest Api
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@PatchMapping("{id}/complete")
	public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId) {

		TodoDto updatedTodo = todoService.completeTodo(todoId);

		return ResponseEntity.ok(updatedTodo);
	}

	// Build inComplete Todo Rest Api
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@PatchMapping("{id}/in-complete")
	public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId) {

		TodoDto updatedTodo = todoService.inCompleteTodo(todoId);

		return ResponseEntity.ok(updatedTodo);
	}
}
