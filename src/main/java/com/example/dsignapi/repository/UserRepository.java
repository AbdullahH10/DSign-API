package com.example.dsignapi.repository;

import com.example.dsignapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

    Optional<User> findByUserId(String userId);

    void deleteByuserId(String userId);

//    Optional<User> findByUserId(String userId);

//    User findByProfileImageLocation(int userId);
//
//    User findBySignatureImageLocation(int userId);

//    User saveByEmail(String email);
}
