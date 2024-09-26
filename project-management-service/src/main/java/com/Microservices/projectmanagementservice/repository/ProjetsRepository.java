package com.Microservices.projectmanagementservice.repository;

import com.Microservices.projectmanagementservice.model.Entity.Projets;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetsRepository extends JpaRepository<Projets, Long> {
//Sort by field

}