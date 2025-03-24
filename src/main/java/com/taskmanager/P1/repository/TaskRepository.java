package com.taskmanager.P1.repository;

import com.taskmanager.P1.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
