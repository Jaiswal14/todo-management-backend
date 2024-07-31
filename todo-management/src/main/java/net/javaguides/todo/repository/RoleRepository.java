package net.javaguides.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.todo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByName(String name);

}
