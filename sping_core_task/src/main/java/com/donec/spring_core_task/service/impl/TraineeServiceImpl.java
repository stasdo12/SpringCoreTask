package com.donec.spring_core_task.service.impl;

import com.donec.spring_core_task.dao.TraineeDAO;
import com.donec.spring_core_task.dao.TrainerDAO;
import com.donec.spring_core_task.model.Trainee;
import com.donec.spring_core_task.service.TraineeService;
import com.donec.spring_core_task.utils.NameGenerator;
import com.donec.spring_core_task.utils.PasswordGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService {

    private TraineeDAO traineeDAO;
    private TrainerDAO trainerDAO;
    private PasswordGeneration passwordGeneration;
    private NameGenerator nameGenerator;



    @Autowired
    public TraineeServiceImpl(TraineeDAO traineeDAO, TrainerDAO trainerDAO, PasswordGeneration passwordGeneration, NameGenerator nameGenerator) {
        this.traineeDAO = traineeDAO;
        this.trainerDAO = trainerDAO;
        this.passwordGeneration = passwordGeneration;
        this.nameGenerator = nameGenerator;
    }


    @Override
    public Optional<Trainee> create(Trainee trainee) {
        long maxId = traineeDAO.getMaxId();

        trainee.setTraineeId(maxId);
        trainee.setUserName(generateUsername(trainee));
        trainee.setPassword(passwordGeneration.generatePassword());

        return traineeDAO.create(maxId, trainee);
    }

    @Override
    public Optional<Trainee> update(Trainee trainee) {
        return traineeDAO.update(trainee);
    }

    @Override
    public boolean delete(long traineeId) {
        return traineeDAO.deleteById(traineeId);
    }

    @Override
    public Optional<Trainee> getById(long traineeId) {
        return traineeDAO.findById(traineeId);
    }

    @Override
    public Optional<Trainee> getByUsername(String username) {
        return traineeDAO.findByUsername(username);
    }

    @Override
    public List<Trainee> getTrainees() {
        return traineeDAO.getAllTrainees();
    }


    private String generateUsername(Trainee trainee) {
        String username = nameGenerator.generateUsername(trainee);

        if (traineeDAO.findByUsername(username).isEmpty() && trainerDAO.getByUsername(username).isEmpty()) {
            return username;
        }

        return nameGenerator.generateUsername(trainee,
                traineeDAO.findAllByUsername(username),
                trainerDAO.getAllTrainersByUsername(username));
    }
}
