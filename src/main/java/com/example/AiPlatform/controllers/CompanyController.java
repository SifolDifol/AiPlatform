package com.example.AiPlatform.controllers;

import com.example.AiPlatform.models.Company;
import com.example.AiPlatform.services.repository.CompanyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CompanyController {

    private CompanyRepository companyRepository;

    private Map<Long, Company> companyList;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        this.companyList = new HashMap();
    }

    public void createCompany(@RequestBody Company company) {
        if(company.getName() == null) throw new RuntimeException("Name cannot be null");
        Company newCompany = new Company();
        BeanUtils.copyProperties( company, newCompany );
        companyRepository.createCompany(newCompany);
        companyList.put(newCompany.getId(), newCompany);
    }

    public Map<Long, Company> getCompanyList() {
        companyList = companyRepository.getCompanyList();
        return companyList;
    }

    public Company getCompanyById(Long id) {
        if( companyList.containsKey(id)) return companyList.get(id);

        return companyRepository.getCompanyById(id);
    }

    public ResponseEntity<String> updateCompany(@RequestBody Company updatedCompany) {
        Company company = new Company();
        BeanUtils.copyProperties( updatedCompany, company );

        companyList.put(updatedCompany.getId(), company );

        companyRepository.updateCompany( company );
        return ResponseEntity.ok( "Company was updated " + company.getId() );
    }

    public void deleteCompany(Long id) {
        companyList.remove(id);
        companyRepository.deleteCompany(id);
    }

    @Deprecated
    public void saveCompanyListToDB(){
        for(Long key: companyList.keySet()){
            companyRepository.createCompany(companyList.get(key));
        }
    }

    public Company getCompanyByName(String name) {
        return companyRepository.findByName(name);
    }

}
