package com.Microservices.resourcemanagementservice.controller;


import com.Microservices.resourcemanagementservice.controller.Api.IRessourcesApi;
import com.Microservices.resourcemanagementservice.model.Dto.RessourcesDTO;
import com.Microservices.resourcemanagementservice.model.Entity.Ressources;
import com.Microservices.resourcemanagementservice.service.RessourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RessourcesController implements IRessourcesApi {

    @Autowired
    private RessourcesService Service;

    @Override
    public RessourcesDTO creerRessources(RessourcesDTO ressources) {
        return Service.createRessources(ressources);
    }

    @Override
    public void supprimerRessources(Long id) {
        Service.deleteRessources(id);
    }

    @Override
    public List<RessourcesDTO> getAllRessources() {
        return Service.getAllRessources();
    }

    @Override
    public RessourcesDTO mettreAjourRessources(Long id, RessourcesDTO ressources) {
        return Service.updateRessources(id, ressources);
    }

    @Override
    public RessourcesDTO getRessourcesById(Long id) {
        return Service.getRessourcesById(id);
    }

    @Override
    public List<Ressources> getAllRessources(Long id) {
        return Service.getAllRessourcesByTaches(id);
    }
}