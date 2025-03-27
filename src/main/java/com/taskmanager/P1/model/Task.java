package com.taskmanager.P1.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.Pattern;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long taskId;
    private String taskName;
    private String description;

    @Pattern(regexp = "Pending|In Progress|Completed",message = "Status must be 'Pending', 'In Progress', or 'Completed'")
    private String status;

}
