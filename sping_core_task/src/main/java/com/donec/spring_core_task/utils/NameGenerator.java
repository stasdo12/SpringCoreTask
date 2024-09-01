package com.donec.spring_core_task.utils;

import com.donec.spring_core_task.model.Trainee;
import com.donec.spring_core_task.model.Trainer;
import com.donec.spring_core_task.model.User;

import java.util.List;

public interface NameGenerator {

    String generateUsername(User user);
    String generateUsername(User user, List<Trainee> trainees, List<Trainer> trainers);
}
