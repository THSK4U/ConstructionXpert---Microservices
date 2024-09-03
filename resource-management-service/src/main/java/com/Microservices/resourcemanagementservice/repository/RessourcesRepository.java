package com.Microservices.resourcemanagementservice.repository;

import com.Microservices.resourcemanagementservice.model.Entity.Ressources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RessourcesRepository extends JpaRepository<Ressources, Long> {

    List<Ressources> getRessourcesByTacheId(Long id);
}
