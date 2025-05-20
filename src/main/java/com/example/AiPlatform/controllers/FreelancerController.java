package com.example.AiPlatform.controllers;

import com.example.AiPlatform.models.Freelancer;
import com.example.AiPlatform.services.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


    @Service
public class FreelancerController {


    private FreelancerRepository freelancerRepository;

    private Map<Integer, Freelancer> taskList;

    @Autowired
    public FreelancerController(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
        this.taskList = new HashMap();
    }

    public void createTask(int id, String name, String description) {
        if(name == null) throw new RuntimeException("Name cannot be null");

        Freelancer freelancer = new Freelancer(id, name, description);
        freelancerRepository.createTask( freelancer );
        taskList.put(id, freelancer );
    }

    public Map<Integer, Freelancer> getTaskList() {
        taskList = freelancerRepository.getTaskList();
        return taskList;
    }

    public Freelancer getTask(Integer id) {
        if(taskList.containsKey(id)) return taskList.get(id);

        return freelancerRepository.getTask(id);
    }

    public void updateTask(Integer taskId, String newName, String newDescription) {
        Freelancer updatedFreelancer = new Freelancer(taskId, newName, newDescription);

        taskList.put(taskId, updatedFreelancer );

        freelancerRepository.updateTask( updatedFreelancer );
    }

    public void deleteTask(Integer id) {
        taskList.remove(id);
        freelancerRepository.deleteTask(id);
    }

    @Deprecated
    public void saveTaskListToDB(){
        for(Integer key: taskList.keySet()){
            freelancerRepository.createTask(taskList.get(key));
        }
    }
}
