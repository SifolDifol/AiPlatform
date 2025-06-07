package com.example.AiPlatform.aiservices.controllers;

import com.example.AiPlatform.aiservices.controllers.spring.SpringAiQueryController;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AiQueryController {




    /*

    private AiQueryController aiQueryController;

    private Map<Integer, Freelancer> taskList;

    @Autowired
    public AiQueryController(AiQueryController aiQueryController) {
        this.aiQueryController = aiQueryController;
        this.taskList = new HashMap();
    }

    public void createTask(int id, String name, String description) {
        if(name == null) throw new RuntimeException("Name cannot be null");

        Freelancer freelancer = new Freelancer(id, name, description);
        freelancerRepository.createTask( freelancer );
        taskList.put(id, freelancer );
    }

    public Map<Integer, Freelancer> getTaskList() {
        taskList = freelancerRepository.getTaskList();
        return taskList;
    }

    public Freelancer getTask(Integer id) {
        if(taskList.containsKey(id)) return taskList.get(id);

        return freelancerRepository.getTask(id);
    }

    public void updateTask(Integer taskId, String newName, String newDescription) {
        Freelancer updatedFreelancer = new Freelancer(taskId, newName, newDescription);

        taskList.put(taskId, updatedFreelancer );

        freelancerRepository.updateTask( updatedFreelancer );
    }

    public void deleteTask(Integer id) {
        taskList.remove(id);
        freelancerRepository.deleteTask(id);
    }

    @Deprecated
    public void saveTaskListToDB(){
        for(Integer key: taskList.keySet()){
            freelancerRepository.createTask(taskList.get(key));
        }
    }
    */
}