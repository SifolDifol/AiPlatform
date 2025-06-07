package com.example.AiPlatform.services.impl;

import com.example.AiPlatform.models.Proposal;
import com.example.AiPlatform.services.repository.ProposalRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class DbProposalRepoImpl implements ProposalRepository {
    @Override
    public void createProposal(Proposal proposal) {

    }

    @Override
    public Proposal getProposal(Long id) {
        return null;
    }

    @Override
    public void updateProposal(Proposal updateProposal) {

    }

    @Override
    public void deleteProposal(Long id) {

    }

    @Override
    public Map<Long, Proposal> getProposalList() {
        return null;
    }
}
