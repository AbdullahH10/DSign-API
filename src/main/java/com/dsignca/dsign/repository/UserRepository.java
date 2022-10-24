package com.dsignca.dsign.repository;


import com.dsignca.dsign.entity.CAUser.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByFirstName(String firstName);

    User findByEmail(String email);
}
