package com.example.AiPlatform.services.impl;

import com.example.AiPlatform.models.Project;
import com.example.AiPlatform.services.repository.ProjectRepository;
import org.springframework.stereotype.Repository;
import java.util.Map;


@Repository
public class DbProjectRepoImpl implements ProjectRepository {

    @Override
    public void createProject(Project project) {

    }

    @Override
    public Project getProject(Long id) {
        return null;
    }

    @Override
    public void updateProject(Project updateProject) {

    }

    @Override
    public void deleteProject(Long id) {

    }

    @Override
    public Map<Long, Project> getProjectList() {
        return null;
    }

    @Override
    public String findByName(String name) {
        return null;
    }
}
