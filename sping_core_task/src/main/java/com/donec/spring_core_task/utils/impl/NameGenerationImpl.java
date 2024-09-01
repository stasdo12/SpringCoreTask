package com.donec.spring_core_task.utils.impl;

import com.donec.spring_core_task.model.Trainee;
import com.donec.spring_core_task.model.Trainer;
import com.donec.spring_core_task.model.User;
import com.donec.spring_core_task.utils.NameGenerator;

import java.util.List;
import java.util.stream.Stream;

public class NameGenerationImpl implements NameGenerator {
    @Override
    public String generateUsername(User user) {
        return user.getFirstName() + "." + user.getLastName();
    }

    @Override
    public String generateUsername(User user, List<Trainee> trainees, List<Trainer> trainers) {
        String baseUsername = generateUsername(user);

        Stream<User> users = Stream.concat(trainees.stream(), trainers.stream());
        int maxIndex = users.map(User::getUserName)
                .map(userName -> userName.replaceAll("\\D+?(\\d+)$", "$1"))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0);
        return baseUsername + (maxIndex +1);
    }
}
