package com.Microservices.projectmanagementservice.controller;


import com.Microservices.projectmanagementservice.controller.Api.IProjetApi;
import com.Microservices.projectmanagementservice.model.Dto.ProjetsDTO;
import com.Microservices.projectmanagementservice.model.ProjetResponse;
import com.Microservices.projectmanagementservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class ProjetController implements IProjetApi {
    @Autowired
    ProjectService Service;

    @Override
    public ProjetsDTO creerProjets(ProjetsDTO Projets) {
        return Service.createProject(Projets);
    }

    @Override
    public void supprimerProjets(Long id) {
        Service.deleteProject(id);
    }

    @Override
    public List<ProjetsDTO> getAllProjets(int page, int size) {
        return Service.getAllProjects(page, size);
    }

    @Override
    public ProjetsDTO mettreAjourProjets(Long id, ProjetsDTO Projets) {
        return Service.updateProject(id, Projets);
    }

    @Override
    public ProjetsDTO getProjetsById(Long id) {
        return Service.getProjectById(id);
    }

    @Override
    public ProjetResponse getTachesByIdProjet(Long id) {
        return Service.projetWithTaches(id);
    }

    @Override
    public List<ProjetsDTO> getProjetWithSort(String field, String direction){
        return Service.findProjectWithSorting(field, direction);
    }

}