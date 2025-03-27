package com.taskmanager.P1.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusUpdateDTO {

    @Pattern(regexp = "Pending|In Progress|Completed", message = "Status must be 'Pending', 'In Progress', or 'Completed'")
    private String status;
}
