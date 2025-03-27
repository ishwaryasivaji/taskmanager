package com.taskmanager.P1.controller;

import com.taskmanager.P1.dto.StatusUpdateDTO;
import com.taskmanager.P1.model.Task;
import com.taskmanager.P1.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tasks")
@Validated
@RestController
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/getalltasks")
    public List<Task> getAllTasks()
    {
        return taskService.getAllTasks();
    }

    @GetMapping("/findtaskbyid/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.findTaskById(id);
        return ResponseEntity.ok(task);
    }


    @PostMapping("/create")
    public Task createTask(@RequestBody @Valid Task task)
    {
        return taskService.createTask(task);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task)
    {
        Task task1 = taskService.updateTask(id,task);
        return ResponseEntity.ok(task1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }

    @PatchMapping("/updatestatus/{id}")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @Valid @RequestBody StatusUpdateDTO statusUpdateDTO) {
        Task updatedTask = taskService.updateStatus(id, statusUpdateDTO.getStatus());
        return ResponseEntity.ok(updatedTask);
    }



}
