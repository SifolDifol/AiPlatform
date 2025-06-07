package com.example.AiPlatform.services;

import com.example.AiPlatform.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Repository
public class LoginService {
    RestTemplate restTemplate = new RestTemplate();

/*    public void signUpUser(User user){
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
    }*/

    public ResponseEntity<String> signUpUser(User user){

        if ( user == null || user.getEmail() == null || user.getPasswordHash() == null ){
            throw new IllegalArgumentException("Main user data cannot be null");
        }
        String url="http://localhost:8084/auth/signup";

        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setEmail(user.getEmail());
        newUser.setPasswordHash(user.getPasswordHash());
        newUser.setRole(user.getRole());
        newUser.setCreatedAt(LocalDateTime.now());
        newUser.setUpdatedAt(LocalDateTime.now());

        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info( "New attempt registration " + newUser.getEmail());

        try{
            ResponseEntity<String> response = restTemplate.postForEntity( url,newUser,String.class );

            logger.info( "Succes registration" + newUser.getEmail() );
            return response;
        }catch (HttpClientErrorException e){
            logger.error( "Registration faild for", newUser.getEmail(), e.getStatusCode());
            throw new RuntimeException("Registration faild "+ e.getResponseBodyAsString());
        }
        catch (ResourceAccessException e){
            logger.error("Auth faild");
            throw new RuntimeException("Auth faild");
        }
    }
    public ResponseEntity<String> signInUser(User user){
        if ( user == null || user.getEmail() == null || user.getPasswordHash() == null ){
            throw new IllegalArgumentException("Main user data cannot be null");
        }
        String url="http://localhost:8084/auth/signup";

        User authUser = new User();
        authUser.setId(user.getId());
        authUser.setPasswordHash(user.getPasswordHash().trim());

        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info( "New attempt auth " + authUser.getId());

        try{
            ResponseEntity<String> response = restTemplate.postForEntity( url,authUser,String.class );

            logger.info("Succes auth" + authUser.getId());
            return response;
        }catch (HttpClientErrorException e){
            logger.error( "Auth faild for", authUser.getId(), e.getStatusCode());
            throw new RuntimeException("Auth faild "+ e.getResponseBodyAsString());
        }
        catch (ResourceAccessException e){
            logger.error("Auth faild");
            throw new RuntimeException("Auth faild");
        }
    }
}
