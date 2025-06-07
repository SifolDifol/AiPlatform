package com.example.AiPlatform.services.impl;

import com.example.AiPlatform.models.Company;
import com.example.AiPlatform.models.User;
import com.example.AiPlatform.services.repository.CompanyRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class DbCompanyRepoImpl implements CompanyRepository {

    private Connection getConnection() throws Exception{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:8081/AiPlatform?user=postgres&password=1";
        return DriverManager.getConnection(url);
    }

    @Override
    public void createCompany(Company company) {
        try {
            String sql = "INSERT INTO companies (id,name,description,industry,website,location,phone,user_id) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setLong (1, company.getId());
            preparedStatement.setString (2, company.getName());
            preparedStatement.setString (3, company.getDescription());
            preparedStatement.setString (4, company.getIndustry());
            preparedStatement.setString (5, company.getWebsite());
            preparedStatement.setString (6, company.getLocation());
            preparedStatement.setString (7, company.getPhone());
            preparedStatement.setLong (8, company.getUser().getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<Long, Company> getCompanyList() {
        Map<Long, Company> companyList = new HashMap<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM companies");
            while(resultSet.next()){

                Company company = new Company();
                company.setId(resultSet.getLong("id"));
                company.setName( resultSet.getString( "name" ) );
                company.setDescription( resultSet.getString( "description" ) );
                company.setIndustry( resultSet.getString( "industry" ) );
                company.setWebsite( resultSet.getString( "website" ) );
                company.setLocation( resultSet.getString( "location" ) );
                company.setPhone( resultSet.getString( "phone" ) );

                companyList.put(company.getId(), company);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return companyList;
    }

    @Override
    public Company getCompanyById(Long id) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT c.*, u.role, u.created_at, u.updated_at FROM companies c INNER JOIN user u ON c.id = u.id WHERE c.ID = ?");){

            preparedStatement.setLong(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    Company company = new Company();
                    company.setId( id );
                    company.setName( resultSet.getString( "name" ) );
                    company.setDescription( resultSet.getString( "description" ) );
                    company.setIndustry( resultSet.getString( "industry" ) );
                    company.setWebsite( resultSet.getString( "website" ) );
                    company.setLocation( resultSet.getString( "location" ) );
                    company.setPhone( resultSet.getString( "phone" ) );
                    return company;
                }
            }
        } catch (Exception e) {
            System.err.println("Compani with this id not found " + id);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCompany(Company updateCompany) {
        String sql = "UPDATE companies SET NAME = ? , DESCRIPTION = ? , INDUSTRY = ?, WEBSITE = ?, LOCATION = ?, PHONE = ? WHERE ID = ?";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, updateCompany.getName());
            preparedStatement.setString(2, updateCompany.getDescription());
            preparedStatement.setString(3, updateCompany.getIndustry());
            preparedStatement.setString(4, updateCompany.getWebsite());
            preparedStatement.setString(5, updateCompany.getLocation());
            preparedStatement.setString(6, updateCompany.getPhone());
            preparedStatement.setLong(7, updateCompany.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error with update data company id " + updateCompany.getId());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(Long id) {
        String sql = "DELETE FROM companies WHERE ID = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Company findByName(String name){
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM companies WHERE name = ?");
            preparedStatement.setString(1, name);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if ( resultSet.next()){
                    Company company = new Company();
                    company.setId(resultSet.getLong("id"));
                    company.setName( resultSet.getString("name"));
                    company.setDescription( resultSet.getString("description"));
                    company.setIndustry( resultSet.getString("industry"));
                    company.setWebsite( resultSet.getString("website"));
                    company.setLocation( resultSet.getString("location"));
                    company.setPhone( resultSet.getString("phone"));
                    return company;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveCompanyListToDB() {

    }

}
