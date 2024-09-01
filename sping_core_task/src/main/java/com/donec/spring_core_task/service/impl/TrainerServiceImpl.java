package com.donec.spring_core_task.service.impl;

import com.donec.spring_core_task.dao.TraineeDAO;
import com.donec.spring_core_task.dao.TrainerDAO;
import com.donec.spring_core_task.model.Trainee;
import com.donec.spring_core_task.model.Trainer;
import com.donec.spring_core_task.service.TrainerService;
import com.donec.spring_core_task.utils.NameGenerator;
import com.donec.spring_core_task.utils.PasswordGeneration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrainerServiceImpl implements TrainerService {

    private TrainerDAO trainerDAO;
    private TraineeDAO traineeDAO;
    private PasswordGeneration passwordGeneration;
    private NameGenerator nameGenerator;


    @Autowired
    public TrainerServiceImpl(TrainerDAO trainerDAO, TraineeDAO traineeDAO, PasswordGeneration passwordGeneration,
                              NameGenerator nameGenerator) {
        this.trainerDAO = trainerDAO;
        this.traineeDAO = traineeDAO;
        this.passwordGeneration = passwordGeneration;
        this.nameGenerator = nameGenerator;
    }

    @Override
    public Optional<Trainer> create(Trainer trainer) {
        long maxId = trainerDAO.getMaxId();

        trainer.setTrainerId(maxId);
        trainer.setUserName(generateUsername(trainer));
        trainer.setPassword(passwordGeneration.generatePassword());

        return trainerDAO.create(maxId, trainer);

    }

    @Override
    public Optional<Trainer> update(Trainer trainer) {
        return trainerDAO.update(trainer);
    }

    @Override
    public Optional<Trainer> getById(long trainerId) {
        return trainerDAO.getById(trainerId);
    }

    @Override
    public Optional<Trainer> getByUsername(String username) {
        return trainerDAO.getByUsername(username);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerDAO.getAllTrainers();
    }

    private String generateUsername(Trainer trainer) {
        String username = nameGenerator.generateUsername(trainer);
        if (traineeDAO.findByUsername(username).isEmpty() && trainerDAO.getByUsername(username).isEmpty()) {
            return username;
        }
        return nameGenerator.generateUsername(trainer,
                traineeDAO.findAllByUsername(username),
                trainerDAO.getAllTrainersByUsername(username));
    }
}
