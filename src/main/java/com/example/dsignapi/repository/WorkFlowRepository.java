package com.example.dsignapi.repository;

import com.example.dsignapi.entity.User;
import com.example.dsignapi.entity.WorkFlow;
import com.example.dsignapi.entity.WorkFlowMembers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkFlowRepository extends JpaRepository<WorkFlow,Integer> {
//    User findByEmail(String email);



    WorkFlow findByWid(int wid);

//    WorkFlow findByWid(int Wid);


//    Optional<Object> findByWid();
}
