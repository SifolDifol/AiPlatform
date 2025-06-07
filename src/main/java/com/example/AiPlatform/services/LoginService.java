package com.example.AiPlatform.services;

import com.example.AiPlatform.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Repository
public class LoginService {
    RestTemplate restTemplate = new RestTemplate();

    public void signUpUser(User user){
        System.out.println("User:" + user);
        String url="http://localhost:8084/auth/signup";

        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setEmail(user.getEmail());
        newUser.setPasswordHash(user.getPasswordHash());
        newUser.setRole(user.getRole());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        ResponseEntity<String> postResponse = restTemplate.postForEntity(url, newUser,String.class);
    }
    public void signInUser(User user){
        String url="http://localhost:8084/auth/login";

        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setPasswordHash(user.getPasswordHash());

        ResponseEntity<String> postResponse = restTemplate.postForEntity(url, newUser,String.class);
    }
}
