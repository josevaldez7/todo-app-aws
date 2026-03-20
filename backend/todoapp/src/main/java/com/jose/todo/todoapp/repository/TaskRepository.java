package com.jose.todo.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.todo.todoapp.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
