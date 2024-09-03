package com.Microservices.resourcemanagementservice.controller.Api;


import com.Microservices.resourcemanagementservice.model.Dto.RessourcesDTO;
import com.Microservices.resourcemanagementservice.model.Entity.Ressources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IRessourcesApi {
    //creer
    @PostMapping(value = "/Ressources/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RessourcesDTO creerRessources(@RequestBody RessourcesDTO ressources);

    //supprimer
    @DeleteMapping(value = "/Ressources/Delete/{id}")
    void supprimerRessources(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = "/Ressources", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RessourcesDTO> getAllRessources();

    //mettre A Jour
    @PutMapping(value = "/Ressources/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RessourcesDTO mettreAjourRessources(@PathVariable("id") Long id,@RequestBody RessourcesDTO ressources);

    //By id
    @GetMapping(value = "/Ressources/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    RessourcesDTO getRessourcesById(@PathVariable("id") Long id);

     //all by id
     @GetMapping(value = "/Taches/Ressources/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
     List<Ressources> getAllRessources(@PathVariable("id") Long id);
}
