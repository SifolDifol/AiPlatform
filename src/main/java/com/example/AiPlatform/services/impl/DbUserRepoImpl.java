package com.example.AiPlatform.services.impl;

import com.example.AiPlatform.models.User;
import com.example.AiPlatform.services.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class DbUserRepoImpl implements UserRepository{

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public Map<Long, User> getUserList() {
        return null;
    }

    @Override
    public void updateUser(User updatedUser) {

    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
