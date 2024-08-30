package com.Microservices.taskmanagementservice.repository;

import com.Microservices.taskmanagementservice.model.Entity.Taches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TachesRepository extends JpaRepository<Taches, Long> {

    List<Taches> findAllByProjetId(Long id);
}
