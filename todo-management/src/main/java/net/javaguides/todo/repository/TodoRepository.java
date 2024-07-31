package net.javaguides.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.todo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
