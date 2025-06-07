package com.example.AiPlatform.controllers.spring;

import com.example.AiPlatform.controllers.CompanyController;
import com.example.AiPlatform.models.Company;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SpringCompanyController {


    private CompanyController companyController;

    @Autowired
    public SpringCompanyController (CompanyController companyController){
        this.companyController = companyController;
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        try {
            companyController.createCompany(company);
            return ResponseEntity.ok( "" + company.getId());
        }catch (Exception e){
            ResponseEntity.internalServerError().body( "" + e.getMessage());
        }
        return ResponseEntity.ok("Company was created " + company.getName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable Long id){
        Company company = companyController.getCompanyById(id);
        if (company == null){
            return ResponseEntity.status( HttpStatus.NOT_FOUND).body("Company not found" + id);
        }
        return ResponseEntity.ok(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id, @RequestBody Company updateCompany){

        if(!id.equals(updateCompany.getId())){
            return ResponseEntity.badRequest().body("Id in path and Id serch not match");
        }

        Company company = companyController.getCompanyById(id);
        BeanUtils.copyProperties(updateCompany, company);

         companyController.updateCompany(company);

        return ResponseEntity.ok("Company with id was updated " + company.getId());
    }

    @GetMapping()
    public ResponseEntity<Map<Long,Company>> getAllCompany(){
        return ResponseEntity.ok(companyController.getCompanyList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        try{
            companyController.deleteCompany(id);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Error with deliting" + id + e.getMessage());
        }
        return ResponseEntity.ok("Company deleted " + id);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Company> getCompanyByName (@PathVariable String name){
        Company company = companyController.getCompanyByName(name);
        if(company != null){
            return ResponseEntity.ok(company);
        }
        return ResponseEntity.notFound().build();
    }

}
