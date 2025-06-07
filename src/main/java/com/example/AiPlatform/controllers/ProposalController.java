package com.example.AiPlatform.controllers;

import com.example.AiPlatform.models.Project;
import com.example.AiPlatform.models.Proposal;
import com.example.AiPlatform.services.repository.ProjectRepository;
import com.example.AiPlatform.services.repository.ProposalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProposalController {

    private ProposalRepository proposalRepository;

    private Map<Long, Proposal> proposalList;

    @Autowired
    public ProposalController(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
        this.proposalList = new HashMap();
    }

    public ResponseEntity<String> createProposal(@ModelAttribute Proposal newProposal) {
        if(newProposal.getId() == null) throw new IllegalArgumentException("ID cannot be null");
        Proposal proposal = new Proposal();
        BeanUtils.copyProperties( newProposal, proposal );
        proposalRepository.createProposal( proposal);
        proposalList.put(newProposal.getId(), proposal);
        return ResponseEntity.ok("Company saved" + proposal.getId());
    }

    public Map<Long, Proposal> getProposalList() {
        proposalList = proposalRepository.getProposalList();
        return proposalList;
    }

    public Proposal getProposal(Long id) {
        if( proposalList.containsKey(id)) return proposalList.get(id);

        return proposalRepository.getProposal(id);
    }

    public ResponseEntity<String> updateProposal(@ModelAttribute Proposal updatedProposal) {
        Proposal proposal = new Proposal();
        BeanUtils.copyProperties( updatedProposal, proposal );

        proposalList.put(updatedProposal.getId(), proposal );

        proposalRepository.updateProposal( proposal );
        return ResponseEntity.ok( "Project was updated " + proposal.getId() );
    }

    public void deleteProject(Long id) {
        proposalList.remove(id);
        proposalRepository.deleteProposal(id);
    }

    @Deprecated
    public void saveProjectListToDB(){
        for(Long key: proposalList.keySet()){
            proposalRepository.createProposal( proposalList.get(key));
        }
    }

}
