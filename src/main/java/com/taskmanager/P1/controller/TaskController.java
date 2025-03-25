package com.taskmanager.P1.controller;

import com.taskmanager.P1.model.Task;
import com.taskmanager.P1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Task findTaskById(@RequestBody Long id)
    {
        return taskService.findTaskById(id);
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task)
    {
        return taskService.createTask(task);
    }

    @PostMapping("/update")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task)
    {
        return taskService.updateTask(id,task);
    }


}
