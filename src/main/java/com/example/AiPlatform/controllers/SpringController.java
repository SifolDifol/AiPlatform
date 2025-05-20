package com.example.AiPlatform.controllers;

import com.example.AiPlatform.models.Freelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SpringController {

    @Autowired
    FreelancerController freelancerController;

    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/AllTask")
    public String allTask(Model model){
        Map<Integer, Freelancer> taskMap = freelancerController.getTaskList();
        List<Freelancer> freelancerList = new ArrayList<Freelancer>(taskMap.values());
        System.out.println( freelancerList );
        model.addAttribute("taskList", freelancerList );
        return "AllFreelancer";
    }

    @GetMapping("/Create")
    public String createTask(Model model){
        return "CreateFreelancer";
    }

    @PostMapping("/Create")
    public String createTask(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, Model model){
        freelancerController.createTask(id, name, description);
        return "CreateFreelancer";
    }

    @GetMapping("/Edit")
    public String editTask(Model model){
        return "EditFreelancer";
    }

    @PostMapping("/Edit")
    public String editTask(@RequestParam Integer id, @RequestParam String name, @RequestParam String description ,Model model){
        freelancerController.updateTask(id, name,description);
        return "AllFreelancer";
    }

    @RequestMapping(value = "/Delete", method = RequestMethod.GET)
    public String deletTask(@RequestParam(name="id") Integer id){
        freelancerController.deleteTask(id);
        return "redirect:AllTask";
    }

    @GetMapping("/Parse")
    public String parsData(Model model){
        return "EditFreelancer";
    }

    @PostMapping("/Parse")
    public String parseData(@RequestParam Integer id, @RequestParam String name, @RequestParam String description ,Model model){
        freelancerController.updateTask(id, name,description);
        return "AllFreelancer";
    }

}
