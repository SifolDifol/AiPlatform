package com.example.AiPlatform.services;

import com.example.AiPlatform.models.Freelancer;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface FreelancerRepository {
    void createTask(Freelancer freelancer);

    Freelancer getTask(Integer id);

    void updateTask(Freelancer updateFreelancer);

    void deleteTask(Integer id);

    Map<Integer, Freelancer> getTaskList();
}