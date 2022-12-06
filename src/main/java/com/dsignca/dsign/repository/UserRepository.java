package com.dsignca.dsign.repository;


import com.dsignca.dsign.entity.CAUser.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByFirstName(String firstName);

    User findByEmail(String email);

    Optional<Object> findByUserId(Integer userId);
}
