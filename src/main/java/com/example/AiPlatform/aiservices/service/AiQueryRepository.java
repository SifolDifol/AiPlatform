package com.example.AiPlatform.aiservices.service;

import com.example.AiPlatform.models.AiQuery;
import com.example.AiPlatform.models.Company;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AiQueryRepository {

    void createAiQuery (AiQuery aiQuery);

    Company getAiQuery (Long id);

    void deleteAiQuery(Long id);

    Map<Long, AiQuery> getAiQueryList();

}
