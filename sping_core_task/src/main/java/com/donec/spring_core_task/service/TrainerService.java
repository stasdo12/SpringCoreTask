package com.donec.spring_core_task.service;

import com.donec.spring_core_task.model.Trainee;
import com.donec.spring_core_task.model.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerService {
    Optional<Trainer> create (Trainee trainee);
    Optional<Trainer> update (Trainee trainee);
    Optional<Trainer> getById (long trainerId);
    Optional<Trainer> getByUsername(String username);
    List<Trainer> getAllTrainers();
}
