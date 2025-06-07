package com.example.AiPlatform.services.repository;

import com.example.AiPlatform.models.Proposal;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ProposalRepository {

    void createProposal(Proposal proposal);

    Proposal getProposal(Long id);

    void updateProposal(Proposal updateProposal);

    void deleteProposal(Long id);

    Map<Long, Proposal> getProposalList();
}
