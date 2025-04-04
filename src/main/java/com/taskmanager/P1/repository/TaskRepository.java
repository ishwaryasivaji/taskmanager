package com.taskmanager.P1.repository;

import com.taskmanager.P1.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    @Query("SELECT t FROM Task t WHERE t.dueDate < CURRENT_DATE")
    List<Task> findOverdueTasks();

}
