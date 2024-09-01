package com.donec.spring_core_task.dao;

import com.donec.spring_core_task.model.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerDAO {
    Optional<Trainer> create(long trainerId, Trainer trainer);
    Optional<Trainer> update (Trainer trainer);
    Optional<Trainer> getById(long trainerId);
    Optional<Trainer> getByUsername(String username);
    List<Trainer> getAllTrainers();
    List<Trainer> getAllTrainersByUsername(String username);

}
