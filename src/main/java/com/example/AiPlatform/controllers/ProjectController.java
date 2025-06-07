package com.example.AiPlatform.controllers;

import com.example.AiPlatform.models.Project;
import com.example.AiPlatform.services.repository.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProjectController {

    private ProjectRepository projectRepository;

    private Map<Long, Project> projectList;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        this.projectList = new HashMap();
    }

    public void createProject(@ModelAttribute Project newProject) {
        if(newProject.getTitle() == null) throw new IllegalArgumentException("Title cannot be null");
        Project project = new Project();
        BeanUtils.copyProperties( newProject, project );
        projectRepository.createProject( project);
        projectList.put(project.getId(), project);
    }

    public Map<Long, Project> getProjectList() {
        projectList = projectRepository.getProjectList();
        return projectList;
    }

    public Project getProject(Long id) {
        if( projectList.containsKey(id)) return projectList.get(id);

        return projectRepository.getProject(id);
    }

    public ResponseEntity<String> updateProject(@ModelAttribute Project updatedCompany) {
        Project project = new Project();
        BeanUtils.copyProperties( updatedCompany, project );

        projectList.put(updatedCompany.getId(), project );

        projectRepository.updateProject( project );
        return ResponseEntity.ok( "Project was updated " + project.getId() );
    }

    public void deleteProject(Long id) {
        projectList.remove(id);
        projectRepository.deleteProject(id);
    }

    @Deprecated
    public void saveProjectListToDB(){
        for(Long key: projectList.keySet()){
            projectRepository.createProject( projectList.get(key));
        }
    }

    public String getProjectByName(String name) {
        return projectRepository.findByName(name);
    }
}
