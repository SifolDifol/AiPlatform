package com.example.AiPlatform.controllers;

import com.example.AiPlatform.models.Freelancer;
import com.example.AiPlatform.models.User;
import com.example.AiPlatform.services.repository.FreelancerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Service
public class FreelancerController {


    private FreelancerRepository freelancerRepository;

    private Map<Long, Freelancer> freelancerList;

    @Autowired
    public FreelancerController(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
        this.freelancerList = new HashMap();
    }

    public void createFreelancer(Long id, String name, String description, User user, String fullName, String bio, BigDecimal rating, String portfolioUrl, BigDecimal hourlyRate, String location, String phone, String website) {
        if(name == null) throw new RuntimeException("Name cannot be null");

        Freelancer freelancer = new Freelancer( id,  name,  description, user, fullName, bio, rating, portfolioUrl, hourlyRate, location, phone, website);
        freelancerRepository.createFreelancer( freelancer );
        freelancerList.put(id, freelancer );
    }

    public Map<Long, Freelancer> getFreelancerList() {
        freelancerList = freelancerRepository.getFreelancerList();
        return freelancerList;
    }

    public Freelancer getFreelancer(Long id) {
        if( freelancerList.containsKey(id)) return freelancerList.get(id);

        return freelancerRepository.getFreelancer(id);
    }

    public void updateTask(Integer taskId, String newName, String newDescription) {
        //Freelancer updatedFreelancer = new Freelancer(taskId, newName, newDescription);

        //freelancerList.put(taskId, updatedFreelancer );

        //freelancerRepository.updateTask( updatedFreelancer );
    }

    public void deleteFreelancer(Long id) {
        freelancerList.remove(id);
        freelancerRepository.deleteFreelancer(id);
    }

    @Deprecated
    public void saveTaskListToDB(){
        for(Long key: freelancerList.keySet()){
            //freelancerRepository.createTask( freelancerList.get(key));
        }
    }
}
