package com.Microservices.taskmanagementservice.controller;



import com.Microservices.taskmanagementservice.controller.Api.ITachesApi;
import com.Microservices.taskmanagementservice.model.Dto.TachesDTO;
import com.Microservices.taskmanagementservice.model.Entity.Taches;
import com.Microservices.taskmanagementservice.model.TachesResponse;
import com.Microservices.taskmanagementservice.service.TachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class TachesController implements ITachesApi {

    @Autowired
    TachesService Service;

    @Override
    public TachesDTO creerTaches(TachesDTO Taches) {
        return Service.createTaches(Taches);
    }

    @Override
    public void supprimerTaches(Long id) {
        Service.deleteTaches(id);
    }

    @Override
    public List<TachesDTO> getAllTaches() {
        return Service.getAllTaches();
    }

    @Override
    public TachesDTO mettreAjourTaches(Long id, TachesDTO Taches) {
        return Service.updateTaches(id, Taches);
    }

    @Override
    public TachesDTO getTachesById(Long id) {
        return Service.getTachesById(id);
    }

    @Override
    public Optional<List<Taches>> getTachesByIdProjet(Long projectId) {
        return Optional.ofNullable(Service.getAllTachesByProjet(projectId));
    }

    @Override
    public TachesResponse getRessoursByIdProjet(Long id) {
        return Service.tachesWithressours(id);
    }

}








