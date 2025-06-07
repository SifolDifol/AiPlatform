package com.example.AiPlatform.services.repository;

import com.example.AiPlatform.models.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface FreelancerRepository {

    void createFreelancer(Freelancer freelancer);

    Freelancer getFreelancer(Long id);

    void updateFreelancer(Freelancer updateFreelancer);

    void deleteFreelancer(Long id);

    Map<Long, Freelancer> getFreelancerList();
}