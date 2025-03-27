package com.taskmanager.P1.service;

import com.taskmanager.P1.exception.TaskNotFoundException;
import com.taskmanager.P1.model.Task;
import com.taskmanager.P1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    private static final Set<String> VALID_STATUSES = Set.of("Pending", "In Progress", "Completed");

    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id)
    {
        return taskRepository.findById(id)
                .orElseThrow( ()-> new TaskNotFoundException("Task with ID"+id+"not found"));
    }

    public Task createTask(Task task)
    {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }
        updatedTask.setTaskId(id);
        return taskRepository.save(updatedTask);
    }

    public void deleteTask(Long id)
    {
        if(!taskRepository.existsById(id))
        {
            throw new TaskNotFoundException("Task with ID " + id + " not found");
        }
        taskRepository.deleteById(id);
    }

    public Task updateStatus(Long id,String status)
    {
        if (!VALID_STATUSES.contains(status)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status! Allowed values: Pending, In Progress, Completed");
        }
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found"));

        task.setStatus(status);
        return taskRepository.save(task);
    }
}
