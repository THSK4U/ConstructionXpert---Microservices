package com.Microservices.projectmanagementservice.repository;

import com.Microservices.projectmanagementservice.model.Entity.Projets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProjetsRepository extends JpaRepository<Projets, Long> {
}
