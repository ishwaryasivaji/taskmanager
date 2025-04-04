package com.taskmanager.P1.scheduler;

import com.taskmanager.P1.model.Task;
import com.taskmanager.P1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ReminderScheduler {

    @Autowired
    private TaskRepository taskRepository;

    // Runs every day at 9 AM
    @Scheduled(fixedRate = 10000)
    public void testScheduler() {
        System.out.println("✅ Scheduler is running: " + java.time.LocalDateTime.now());
    }
}

