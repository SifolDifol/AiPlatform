package com.example.AiPlatform.controllers;

import com.example.AiPlatform.models.Task;
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
    TaskController taskController;

    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/AllTask")
    public String allTask(Model model){
        Map<Integer, Task> taskMap = taskController.getTaskList();
        List<Task> taskList = new ArrayList<Task>(taskMap.values());
        System.out.println(taskList);
        model.addAttribute("taskList",taskList);
        return "AllTask";
    }

    @GetMapping("/Create")
    public String createTask(Model model){
        return "CreateTask";
    }

    @PostMapping("/Create")
    public String createTask(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, Model model){
        taskController.createTask(id, name, description);
        return "CreateTask";
    }

    @GetMapping("/Edit")
    public String editTask(Model model){
        return "EditTask";
    }

    @PostMapping("/Edit")
    public String editTask(@RequestParam Integer id, @RequestParam String name, @RequestParam String description ,Model model){
        taskController.updateTask(id, name,description);
        return "AllTask";
    }

    @RequestMapping(value = "/Delete", method = RequestMethod.GET)
    public String deletTask(@RequestParam(name="id") Integer id){
        taskController.deleteTask(id);
        return "redirect:AllTask";
    }

    @GetMapping("/Parse")
    public String parsData(Model model){
        return "EditTask";
    }

    @PostMapping("/Parse")
    public String parseData(@RequestParam Integer id, @RequestParam String name, @RequestParam String description ,Model model){
        taskController.updateTask(id, name,description);
        return "AllTask";
    }

}
