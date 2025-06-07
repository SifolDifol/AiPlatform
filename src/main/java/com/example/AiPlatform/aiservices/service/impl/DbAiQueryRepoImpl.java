package com.example.AiPlatform.aiservices.service.impl;

import com.example.AiPlatform.models.AiQuery;
import com.example.AiPlatform.models.Company;
import com.example.AiPlatform.aiservices.service.AiQueryRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DbAiQueryRepoImpl implements AiQueryRepository {
    @Override
    public void createAiQuery(AiQuery aiQuery) {

    }

    @Override
    public Company getAiQuery(Long id) {
        return null;
    }

    @Override
    public void deleteAiQuery(Long id) {

    }

    @Override
    public Map<Long, AiQuery> getAiQueryList() {
        return null;
    }
}
