package com.example.AiPlatform.services.repository;

import com.example.AiPlatform.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ProjectRepository{

    void createProject(Project project);
    Project getProject(Long id);
    void updateProject(Project updateProject);
    void deleteProject(Long id);
    Map<Long, Project> getProjectList();

    String findByName(String name);
}
