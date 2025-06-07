package com.example.AiPlatform.services.repository;

import com.example.AiPlatform.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository{

    Optional<User> findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);
    void createUser(User user);
    Map<Long, User> getUserList();

    void updateUser(User updatedUser);
    User getUser(Long id);
    void deleteUser(Long id);
}
