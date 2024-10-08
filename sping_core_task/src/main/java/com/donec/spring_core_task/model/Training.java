package com.donec.spring_core_task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Training {
    private long trainingId;
    private long traineeId;
    private long trainerId;
    private TrainingType trainingType;
    private LocalDate date;
    private int durationMinutes;
}
