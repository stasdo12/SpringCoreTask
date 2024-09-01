package com.donec.spring_core_task.dao;

import com.donec.spring_core_task.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineeDAO {

    Optional<Trainee> create (long traineeId, Trainee trainee);
    Optional<Trainee> update (Trainee trainee);
    boolean deleteById(long traineeId);
    Optional<Trainee> findById(long traineeId);
    Optional<Trainee> findByUsername(String username);
    List<Trainee> getAllTrainees();
    List<Trainee> findAllByUsername(String username);
    long getMaxId();
}
