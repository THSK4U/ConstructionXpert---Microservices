package com.Microservices.taskmanagementservice.repository;

import com.Microservices.taskmanagementservice.model.Entity.Taches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TachesRepository extends JpaRepository<Taches, Long> {
}
