package com.Microservices.taskmanagementservice.client;

import com.Microservices.taskmanagementservice.model.Entity.Ressources;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ressources-service", url = "${application.config.taches-url}")
public interface ressourcesClient {

    @GetMapping("/Tache/{id}")
    List<Ressources> findressourcesByTache(@PathVariable Long id);
}

