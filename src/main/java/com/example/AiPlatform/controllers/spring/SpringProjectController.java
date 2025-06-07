package com.example.AiPlatform.controllers.spring;

import com.example.AiPlatform.controllers.ProjectController;
import com.example.AiPlatform.models.Company;
import com.example.AiPlatform.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projects")
public class SpringProjectController{
/*
    @Autowired
    private ProjectController projectController;

    @GetMapping("/AllProject")
    public String allProject(Model model){
        Map<Long, Project> projectMap = projectController.getProjectList();
        List<Project> projectList = new ArrayList<Project>(projectMap.values());
        System.out.println(projectList);
        model.addAttribute("projectList",projectList);
        return "AllProject";
    }

    @GetMapping("/Create")
    public String createProject(Model model){
        return "CreateProject";
    }

    @PostMapping("/Create")
    public String createProject(@RequestBody Project project){
        project.setCreatedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        projectController.createProject(project);
        return "CreateProject";
    }

    @GetMapping("/Edit")
    public String editProject(Model model){
        return "EditTask";
    }

    @PostMapping("/Edit")
    public String editProject(@RequestBody Project project){
        projectController.updateProject(project);
        return "AllProject";
    }

    @RequestMapping(value = "/Delete", method = RequestMethod.GET)
    public String deletProject(@RequestParam(name="id") Long id){
        projectController.deleteProject(id);
        return "redirect:AllProject";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getCompanyById(@PathVariable Long id){
        Project project = projectController.getProject(id);
                return ResponseEntity.ok(project);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProjectById(@PathVariable Long id, @RequestBody Project updateProject){

        Project project = projectController.getProject(id);
        project.setTitle(updateProject.getTitle());
        project.setDescription(updateProject.getDescription());
        project.setBudget(updateProject.getBudget());
        project.setDeadline(updateProject.getDeadline());
        project.setStatus(updateProject.getStatus());
        project.setUpdatedAt(updateProject.getUpdatedAt());

        projectController.updateProject(project);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        projectController.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/serchByName")
    public ResponseEntity<Company> findeProjectByName(@PathVariable String name){
        projectController.getProjectByName(name);
        return ResponseEntity.noContent().build();
    }*/
}
