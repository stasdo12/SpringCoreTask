package com.donec.spring_core_task.service.impl;

import com.donec.spring_core_task.dao.TrainingDAO;
import com.donec.spring_core_task.model.Training;
import com.donec.spring_core_task.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrainingServiceImpl implements TrainingService {

    private TrainingDAO trainingDAO;


    @Autowired
    public TrainingServiceImpl(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }


    @Override
    public Optional<Training> create(Training training) {
        long maxId = trainingDAO.getMaxId();
        training.setTrainingId(maxId);
        return trainingDAO.create(maxId, training);
    }

    @Override
    public Optional<Training> findById(long trainingId) {
        return trainingDAO.getById(trainingId);
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingDAO.getAllTrainings();
    }
}
