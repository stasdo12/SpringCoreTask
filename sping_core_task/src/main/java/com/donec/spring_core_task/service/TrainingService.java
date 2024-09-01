package com.donec.spring_core_task.service;

import com.donec.spring_core_task.model.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingService {

    Optional<Training> create (Training training);
    Optional<Training> findById(long trainingId);
    List<Training> getAllTrainings();
}
