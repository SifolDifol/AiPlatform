package com.example.AiPlatform.aiservices.controllers;


import com.example.AiPlatform.models.AiQuery;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@Service
public class AiQueryController {

    private static final String API_URL = "https://api.deepseek.com/v1/chat/completions";
    private static final String API_KEY = "your_api_key_here"; // Замените на ваш ключ

    private RestTemplate restTemplate;

    public AiQueryController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AiQuery getChatCompletion(AiQuery aiQuery) {
        try {
            String requestBody = String.format(
                    "{\"model\":\"deepseek-chat\",\"messages\":[{\"role\":\"user\",\"content\":\"%s\"}],\"temperature\":0.7}",
                    aiQuery.getQueryText().replace("\"", "\\\"")
            );

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer " + API_KEY);

            ResponseEntity<String> response = restTemplate.exchange(
                    API_URL,
                    HttpMethod.POST,
                    new HttpEntity<>(requestBody, headers),
                    String.class
            );

            String responseBody = response.getBody();
            aiQuery.setResponseText(extractContentFromResponse(responseBody));
            aiQuery.setStatus(AiQuery.QueryStatus.COMPLETED);
        } catch (Exception e) {
            aiQuery.setResponseText("Error: " + e.getMessage());
            aiQuery.setStatus(AiQuery.QueryStatus.FAILED);
        }

        return aiQuery;
    }

    private String extractContentFromResponse(String jsonResponse) {
        // Упрощенный парсинг JSON ответа
        try {
            int start = jsonResponse.indexOf("\"content\":\"") + 11;
            int end = jsonResponse.indexOf("\"", start);
            return jsonResponse.substring(start, end).replace("\\n", "\n");
        } catch (Exception e) {
            return "Could not parse response: " + jsonResponse;
        }
    }
}
/*
    String Api_key = "";
    private RestTemplate restTemplate;
    private String AIURL = "url";


    public AiQueryController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String sentRequsetToAi(String queryText) {
        AiRequest.Message systemMessage = new AiRequest.Message();
        systemMessage.setRole("system");
        systemMessage.setContent("Ты полезный ассистент, который отвечает на вопросы.");

        AiRequest.Message userMsg = new AiRequest.Message();
        userMsg.setRole("user");
        userMsg.setContent(userMessage);

        AiRequest request = new AiRequest();
        request.setModel("deepseek-chat");
        request.setMessages(new AiRequest.Message[]{systemMessage, userMsg});
        request.setTemperature(0.7);
        request.setMaxTokens(1000);
        request.setTopP(1.0);
        request.setStream(false);

        // Преобразование в JSON
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error creating request", e);
        }
    }
*/

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

}*/