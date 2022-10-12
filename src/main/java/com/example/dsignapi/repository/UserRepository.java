package com.example.dsignapi.repository;

import com.example.dsignapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

//    User saveByEmail(String email);
}
