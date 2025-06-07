package com.example.AiPlatform.aiservices.controllers.spring;

import com.example.AiPlatform.aiservices.AiIntegrationService;
import com.example.AiPlatform.aiservices.controllers.AiQueryController;
import com.example.AiPlatform.aiservices.controllers.AiResponse;
import com.example.AiPlatform.models.AiQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/deepseek")
public class SpringAiQueryController {
        private final AiQueryController aiQueryController;

        public SpringAiQueryController(AiQueryController aiQueryController) {
            this.aiQueryController = aiQueryController;
        }

    @PostMapping("/query")
    public AiQuery processAiQuery(@RequestBody AiQuery aiQuery) {
        aiQuery.setCreatedAt( LocalDateTime.now());
        return aiQueryController.getChatCompletion(aiQuery);
    }



        /*
    private AiQueryController aiQueryController;

    public SpringAiQueryController(AiQueryController aiQueryController){
        this.aiQueryController = aiQueryController;
    }

    @PostMapping("/ask")
    public ResponseEntity<String> askAi(@RequestBody String queryText){
        String response = aiQueryController.sentRequsetToAi(queryText);
        return ResponseEntity.ok(response);
    }
*/
    }
