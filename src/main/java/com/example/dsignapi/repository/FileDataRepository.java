package com.example.dsignapi.repository;

import com.example.dsignapi.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository <FileData,Integer>{
    Optional <FileData> findByworkFlowName(String workFlowName);
}
