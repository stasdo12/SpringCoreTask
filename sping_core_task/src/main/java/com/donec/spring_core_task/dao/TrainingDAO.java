package com.donec.spring_core_task.dao;

import com.donec.spring_core_task.model.Training;

import java.util.List;
import java.util.Optional;

public interface TrainingDAO {
    Optional<Training> create(Training training);
    Optional<Training> getById(int trainingId);
    List<Training> getAllTrainings();
}
