package com.example.AiPlatform.services.repository;

import com.example.AiPlatform.models.Company;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface CompanyRepository{

    void createCompany(Company company);
    Map<Long, Company> getCompanyList();
    Company getCompanyById(Long id);
    void updateCompany(Company updateCompany);
    void deleteCompany(Long id);
    void saveCompanyListToDB();
    Company findByName(String name);

}
