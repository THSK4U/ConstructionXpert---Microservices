package com.Microservices.projectmanagementservice.repository;

import com.Microservices.projectmanagementservice.model.Entity.Projets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProjetsRepository extends JpaRepository<Projets, Long> {

}
