package com.donec.spring_core_task.service;

import com.donec.spring_core_task.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineeService {

    Optional<Trainee> create (Trainee trainee);
    Optional<Trainee> update (Trainee trainee);
    boolean delete (long traineeId);
    Optional<Trainee> getById(long traineeId);
    Optional<Trainee> getByUsername(String username);
    List<Trainee> getTrainees();

}
