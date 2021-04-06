package com.frank.project.service;


import java.util.Optional;

import com.frank.project.model.Task;
import com.frank.project.repository.TaskRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    public Optional<Task> getTaskdata(Long id) {
        return taskRepo.findById(id);
    }
}
