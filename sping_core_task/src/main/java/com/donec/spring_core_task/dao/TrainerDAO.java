package com.donec.spring_core_task.dao;

import com.donec.spring_core_task.model.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerDAO {
    Optional<Trainer> create(int trainerId, Trainer trainer);
    Optional<Trainer> update (Trainer trainer);
    Optional<Trainer> getById(int trainerId);
    Optional<Trainer> getByUsername(String username);
    List<Trainer> getAllTrainers();
    List<Trainer> getAllTrainersByUsername(String username);

}
