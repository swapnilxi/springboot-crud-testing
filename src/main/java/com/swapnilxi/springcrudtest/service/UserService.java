package com.swapnilxi.springcrudtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapnilxi.springcrudtest.entity.User;
import com.swapnilxi.springcrudtest.repository.UserRepository;
@Service
public class UserService {
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // public boolean isUserExists(String username, String email){
    //     return userRepository.findByUsername(username).isPresent()|| userRepository.findByEmail(email).isPresent();

    // }
    public boolean isUserExists(String username, String email){
        return userRepository.findByUsername(username).isPresent()|| userRepository.findByEmail(email).isPresent();

    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
}
