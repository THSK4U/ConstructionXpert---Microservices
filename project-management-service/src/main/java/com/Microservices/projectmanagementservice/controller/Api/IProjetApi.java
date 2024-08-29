package com.Microservices.projectmanagementservice.controller.Api;

import com.Microservices.projectmanagementservice.model.Dto.ProjetsDTO;
import com.Microservices.projectmanagementservice.model.ProjetResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProjetApi {
    //creer
    @PostMapping(value = "/Projets/Creer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProjetsDTO creerProjets(@RequestBody ProjetsDTO Projets);

    //supprimer
    @DeleteMapping(value = "/Projets/Delete/{id}")
    void supprimerProjets(@PathVariable("id") Long id);

    //Tous
    @GetMapping(value = "/Projets", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProjetsDTO> getAllProjets();

    //mettre A Jour
    @PutMapping(value = "/Projets/MettreAjour/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ProjetsDTO mettreAjourProjets(@PathVariable("id") Long id,@RequestBody ProjetsDTO Projets);

    //By id
    @GetMapping(value = "/Projets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProjetsDTO getProjetsById(@PathVariable("id") Long id);

    //By id and taches
    @GetMapping(value = "/Projets/Taches/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProjetResponse getTachesByIdProjet(@PathVariable("id") Long id);

}
