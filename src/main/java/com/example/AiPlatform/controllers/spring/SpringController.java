package com.example.AiPlatform.controllers.spring;

import com.example.AiPlatform.models.Freelancer;
import com.example.AiPlatform.models.User;
import com.example.AiPlatform.services.LoginService;
import com.example.AiPlatform.services.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@Controller
public class SpringController {


    /*//<Freelancer Service>
    @Autowired
    FreelancerController freelancerController;

    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/AllTask")
    public String allTask(Model model){
        Map<Long, Freelancer> taskMap = freelancerController.getFreelancerList();
        List<Freelancer> freelancerList = new ArrayList<Freelancer>(taskMap.values());
        System.out.println( freelancerList );
        model.addAttribute("freelancerList", freelancerList );
        return "AllFreelancer";
    }

    @GetMapping("/Create")
    public String createTask(Model model){
        return "CreateFreelancer";
    }

    @PostMapping("/Create")
    public String createTask(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, Model model){
    //    freelancerController.createFreelancer(id, name, description);
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
    }*/


    //<User service>
    UserRepository userRepository;

    @Autowired
    LoginService loginService;

    @GetMapping("/signup")
    public String signUpUser() {
        return "signin";
    }

    @PostMapping("/signup")
    public ModelAndView signUpUser(@ModelAttribute User loginInfo){
        loginService.signUpUser(loginInfo);
        ModelAndView model = new ModelAndView("signup");
        model.addObject("ID", loginInfo.getId());
        model.addObject("email",loginInfo.getEmail());
        model.addObject("password",loginInfo.getPasswordHash());
        userRepository.createUser( loginInfo );
        return model;
    }

    @GetMapping("/signin")
    public String signInUser() {
        return "signin";
    }

    @PostMapping("/signin")
    public ModelAndView signInUser(@ModelAttribute User signInInfo){
        loginService.signInUser(signInInfo);
        ModelAndView model = new ModelAndView("signin");
        model.addObject("ID", signInInfo.getId());
        model.addObject("email",signInInfo.getEmail());
        model.addObject("password",signInInfo.getPasswordHash());
        return model;
    }


    //<Project service>






}
