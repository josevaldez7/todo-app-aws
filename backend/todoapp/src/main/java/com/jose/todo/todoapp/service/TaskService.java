package com.jose.todo.todoapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jose.todo.todoapp.model.Task;
import com.jose.todo.todoapp.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo){
        this.repo = repo;
    }

    public List<Task> getAllTasks(){
        return repo.findAll();
    }

    public Task createTask(Task task){
        return repo.save(task);
    }

    public void deleteTask(Long id){
        repo.deleteById(id);
    }

    public Task updateTask(Long id, Task updatedTask){
        Task existingTask = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found"));
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setCompleted(updatedTask.isCompleted());

        return repo.save(existingTask);
    }
}
