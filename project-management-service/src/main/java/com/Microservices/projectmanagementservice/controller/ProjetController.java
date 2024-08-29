package com.Microservices.projectmanagementservice.controller;


import com.Microservices.projectmanagementservice.model.Dto.ProjetsDTO;
import com.Microservices.projectmanagementservice.model.Entity.Projets;
import com.Microservices.projectmanagementservice.model.ProjetResponse;
import com.Microservices.projectmanagementservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projets/")
public class ProjetController {
    @Autowired
    ProjectService projetsService;

    @PostMapping("add")
    public Projets addProjet(@RequestBody Projets projets){
        return projetsService.ajouterProjet(projets);
    }

    @GetMapping("all")
    public List<Projets> getAll(){
        return projetsService.allProjets();
    }

    @GetMapping("{id}")
    public ProjetResponse projetWithTaches(@PathVariable Long id){
        return projetsService.projetWithTaches(id);
    }

    @PutMapping("edit/{id}")
    public Projets edit(@PathVariable Long id, @RequestBody Projets projets){
        return projetsService.modifierProjet(id, projets);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        projetsService.supprimerProjet(id);
    }
}