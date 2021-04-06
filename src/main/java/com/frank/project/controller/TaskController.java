
package com.frank.project.controller;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import com.frank.project.repository.TaskRepo;
import com.frank.project.service.TaskService;
import com.frank.project.exception.CustomizedException;
import com.frank.project.model.Task;


import org.springframework.beans.factory.annotation.*;

import org.springframework.http.HttpStatus;

import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    TaskService taskService;

    @GetMapping("/getAll")
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Optional<Task> getOne(@PathVariable Long id) {
        
        return taskService.getTaskdata(id);
    }

    @PostMapping("/addtask")
    public Task addTask(@RequestBody Task task) {
        return taskRepo.save(task);
    }

    @PutMapping("/updateTask/{id}")
    public Task addTask(@Valid @PathVariable Long id, @RequestBody Task task, Errors error) {
        
        if(error.hasErrors()) throw new CustomizedException("id: "+id, HttpStatus.BAD_REQUEST);
        Optional<Task> task1 = taskRepo.findById(id);
        
        if(!task1.isPresent()) throw new CustomizedException("id: "+id, HttpStatus.NOT_FOUND);
        Task tasknew = task1.get();

        tasknew.setDescrption(task.getDescrption());
        tasknew.setPriority(task.getPriority());

        return taskRepo.save(tasknew);
    }

}