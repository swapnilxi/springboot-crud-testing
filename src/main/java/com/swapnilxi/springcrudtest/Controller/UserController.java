package com.swapnilxi.springcrudtest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swapnilxi.springcrudtest.entity.Product;
import com.swapnilxi.springcrudtest.entity.User;
import com.swapnilxi.springcrudtest.repository.UserRepository;
import com.swapnilxi.springcrudtest.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired 
    UserService userService;

    @GetMapping("/users")
    public List<User> getUserName(){
        return userRepository.findAll();
    }
    
     @PostMapping("adduser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
      try {
         if (userService.isUserExists(user.getUsername(), user.getEmail())) {
          System.out.println("User exist already");
          return ResponseEntity.status(HttpStatus.CONFLICT).body("Username or Email already exists for : " + user.getEmail());
        }
        
        User createdUser = userService.createUser(user);
      System.out.println("new user created");
        return ResponseEntity.ok("User created successfully");
    

      } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.CONFLICT).body("User not created");
      }
      
    }
    
}
