package com.Microservices.taskmanagementservice.controller.Api;


import com.Microservices.taskmanagementservice.model.Dto.TachesDTO;
import com.Microservices.taskmanagementservice.model.Entity.Taches;
import com.Microservices.taskmanagementservice.model.TachesResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ITachesApi {
    //creer
    @PostMapping(value = "/Taches/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    TachesDTO creerTaches(@RequestBody TachesDTO Taches);

    //supprimer
    @DeleteMapping(value = "/Taches/Delete/{id}")
    void supprimerTaches(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = "/Taches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<TachesDTO> getAllTaches();

    //mettre A Jour
    @PutMapping(value = "/Taches/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    TachesDTO mettreAjourTaches(@PathVariable("id") Long id,@RequestBody TachesDTO Taches);

    //By id
    @GetMapping(value = "/Taches/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    TachesDTO getTachesById(@PathVariable("id") Long id);

    //By id and taches
    @GetMapping(value = "/Projet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Optional<List<Taches>> getTachesByIdProjet(@PathVariable("id") Long id);

    //get ress by idtach
    @GetMapping(value = "/Ressources/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    TachesResponse getRessoursByIdProjet(@PathVariable("id") Long id);
}
