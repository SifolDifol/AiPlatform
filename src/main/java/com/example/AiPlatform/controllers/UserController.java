package com.example.AiPlatform.controllers;

import com.example.AiPlatform.models.Company;
import com.example.AiPlatform.models.User;
import com.example.AiPlatform.services.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
public class UserController {
    private UserRepository userRepository;

    private Map<Long, User> userList;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userList = new HashMap();
    }

    public ResponseEntity<String> createUser(@ModelAttribute User newUser) {
        if(newUser.getEmail() == null) throw new RuntimeException("Email cannot be null");
        User user = new User();
        BeanUtils.copyProperties(newUser, user);
        userRepository.createUser(user);
        userList.put(newUser.getId(), user);
        return ResponseEntity.ok("User was created" + user.getId());
    }

    public Map<Long, User> getUserList() {
        userList = userRepository.getUserList();
        return userList;
    }

    public User getUser(Long id) {
        if( userList.containsKey(id)) return userList.get(id);

        return userRepository.getUser(id);
    }

    public void updateUser(Long userId, String newEmail, LocalDateTime newUpdatedAt) {
        User updatedUser = new User(userId, newEmail, newUpdatedAt);

        userList.put(userId, updatedUser);

        userRepository.updateUser(updatedUser);
    }

    public void deleteUser(Long id) {
        userList.remove(id);
        userRepository.deleteUser(id);
    }

    @Deprecated
    public void saveUserListToDB(){
        for(Long key: userList.keySet()){
            userRepository.createUser( userList.get(key));
        }
    }

}
