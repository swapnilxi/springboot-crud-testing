package com.swapnilxi.springcrudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swapnilxi.springcrudtest.entity.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUsername(String username);
    // Optional<User> findByEmail(String email);


    @Query("SELECT u.username, u.email FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);



    
}
