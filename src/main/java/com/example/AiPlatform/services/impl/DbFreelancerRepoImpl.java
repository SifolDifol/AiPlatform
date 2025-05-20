package com.example.AiPlatform.services.impl;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import com.example.AiPlatform.models.Freelancer;
import com.example.AiPlatform.services.FreelancerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DbFreelancerRepoImpl implements FreelancerRepository {

    private Connection getConnection() throws Exception{
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:8081/AiPlatform?user=postgres&password=1";
        return DriverManager.getConnection(url);
    }

    @Override
    public void createTask(Freelancer freelancer) {
        try {
            String sql = "INSERT INTO task (id,name,description) VALUES (?,?,?)";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt (1, freelancer.getId());
            preparedStatement.setString (2, freelancer.getName());
            preparedStatement.setString (3, freelancer.getDescription());
            int rows = preparedStatement.executeUpdate();
            System.out.printf("Added %d rows", rows);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Freelancer getTask(Integer id) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM task WHERE ID = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            // Example: 1 | Задача 1 | Описание 1
            while(resultSet.next()){
                return new Freelancer(id, resultSet.getString(2), resultSet.getString(3));
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
            preparedStatement.setInt(3, updatedFreelancer.getId());
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
    public Map<Integer, Freelancer> getTaskList() {
        Map<Integer, Freelancer> taskList = new HashMap<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM task");
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                Freelancer freelancer = new Freelancer(id, name, description);
                taskList.put(id, freelancer );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;
    }
}
