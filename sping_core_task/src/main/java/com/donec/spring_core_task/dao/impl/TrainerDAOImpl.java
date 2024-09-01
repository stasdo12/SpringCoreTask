package com.donec.spring_core_task.dao.impl;

import com.donec.spring_core_task.dao.TrainerDAO;
import com.donec.spring_core_task.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TrainerDAOImpl implements TrainerDAO {

    private Map<Long, Trainer> trainersStorage;

    @Autowired
    public TrainerDAOImpl(Map<Long, Trainer> trainersStorage) {
        this.trainersStorage = trainersStorage;
    }

    @Override
    public Optional<Trainer> create(long  trainerId, Trainer trainer) {
        trainersStorage.put(trainerId, trainer);
        return getById(trainerId);
    }

    @Override
    public Optional<Trainer> update(Trainer trainer) {
        return Optional.ofNullable(trainersStorage.replace(trainer.getTrainerId(), trainer));
    }

    @Override
    public Optional<Trainer> getById(long trainerId) {
        return Optional.ofNullable(trainersStorage.get(trainerId));
    }

    @Override
    public Optional<Trainer> getByUsername(String username) {
        return  trainersStorage.values()
                .stream()
                .filter(trainer -> trainer.getUserName().equals(username))
                .findAny();
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return new ArrayList<>(trainersStorage.values());
    }

    @Override
    public List<Trainer> getAllTrainersByUsername(String username) {
        return trainersStorage.values()
                .stream()
                .filter(trainer -> trainer.getUserName().matches(username + "\\d+"))
                .collect(Collectors.toList());
    }

    @Override
    public long getMaxId() {
        return trainersStorage.keySet().stream().max(Long::compareTo).orElse(0L) + 1;
    }
}
