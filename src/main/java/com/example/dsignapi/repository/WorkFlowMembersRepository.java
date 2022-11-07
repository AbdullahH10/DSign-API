package com.example.dsignapi.repository;

import com.example.dsignapi.entity.WorkFlowMembers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkFlowMembersRepository extends JpaRepository<WorkFlowMembers,Integer> {
    WorkFlowMembers findByWfId(int wfId);

}
