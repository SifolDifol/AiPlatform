package com.example.AiPlatform.services.impl;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import com.example.AiPlatform.models.Freelancer;
import com.example.AiPlatform.services.repository.FreelancerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DbFreelancerRepoImpl implements FreelancerRepository {
    @Override
    public void createFreelancer(Freelancer freelancer) {

    }

    @Override
    public Freelancer getFreelancer(Long id) {
        return null;
    }

    @Override
    public void updateFreelancer(Freelancer updateFreelancer) {

    }

    @Override
    public void deleteFreelancer(Long id) {

    }

    @Override
    public Map<Long, Freelancer> getFreelancerList() {
        return null;
    }

/*    private Connection getConnection() throws Exception{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:8081/AiPlatform?user=postgres&password=1";
        return DriverManager.getConnection(url);
    }

    @Override
    public void createFreelancer(Freelancer freelancer) {
        try {
            String sql = "INSERT INTO task (id,name,description) VALUES (?,?,?)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setLong (1, freelancer.getId());
            preparedStatement.setString (2, freelancer.getName());
            preparedStatement.setString (3, freelancer.getDescription());
            int rows = preparedStatement.executeUpdate();
            System.out.printf("Added %d rows", rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Freelancer getFreelancer(Integer id) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM task WHERE ID = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            // Example: 1 | Задача 1 | Описание 1
            while(resultSet.next()){
            //    return new Freelancer(id, resultSet.getString(2), resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateTask(Freelancer updatedFreelancer) {
        try{
            String sql = "UPDATE task SET NAME = ? , DESCRIPTION = ? WHERE ID = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, updatedFreelancer.getName());
            preparedStatement.setString(2, updatedFreelancer.getDescription());
            preparedStatement.setLong(3, updatedFreelancer.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(Integer id) {
        try {
            String sql = "DELETE FROM task WHERE ID = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public Map<Long, Freelancer> getFreelancerList() {
        Map<Long, Freelancer> freelancerList = new HashMap<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM freelancers");
            while(resultSet.next()){
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                String user = resultSet.getString(4);
                String fullName = resultSet.getString(5);
                String bio = resultSet.getString(6);
                BigDecimal rating = resultSet.getBigDecimal(7);
                String portfolioUrl = resultSet.getString(8);
                BigDecimal hourlyRate = resultSet.getBigDecimal(9);
                String location = resultSet.getString(10);
                String phone = resultSet.getString(11);
                String website = resultSet.getString(12);
                //Freelancer freelancer = new Freelancer(id, name, description, user, fullName, bio, rating, portfolioUrl, hourlyRate, location, phone, website);
                //freelancerList.put(id, freelancer );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return freelancerList;
    }*/
}

