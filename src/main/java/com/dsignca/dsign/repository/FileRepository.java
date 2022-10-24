package com.dsignca.dsign.repository;

import com.dsignca.dsign.entity.CAUser.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FileRepository extends JpaRepository<FileData,Integer> {

    Optional<FileData> findByFileName(String fileName);
}
