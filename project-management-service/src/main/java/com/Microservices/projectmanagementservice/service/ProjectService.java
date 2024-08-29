package com.Microservices.projectmanagementservice.service;

import com.Microservices.projectmanagementservice.client.TachesClient;
import com.Microservices.projectmanagementservice.model.Dto.ProjetsDTO;
import com.Microservices.projectmanagementservice.model.Entity.Projets;
import com.Microservices.projectmanagementservice.model.Entity.Taches;
import com.Microservices.projectmanagementservice.model.Mapper.ProjetsMapper;
import com.Microservices.projectmanagementservice.model.ProjetResponse;
import com.Microservices.projectmanagementservice.repository.ProjetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {


    @Autowired
    ProjetsRepository projetsRepository;
    @Autowired
    TachesClient tachesClient;

    public Projets ajouterProjet(Projets projet) {
        return projetsRepository.save(projet);
    }

    public Projets modifierProjet(Long id, Projets projet) {
        Projets edited = new Projets();
        edited.setId(id);
        edited.setNom(projet.getNom());
        edited.setDescription(projet.getDescription());
        edited.setBudget(projet.getBudget());
        edited.setDateDebut(projet.getDateDebut());
        edited.setDateFin(projet.getDateFin());
        return projetsRepository.save(edited);
    }

    public List<Projets> allProjets() {
        return projetsRepository.findAll();
    }

    public void supprimerProjet(Long id) {
        projetsRepository.deleteById(id);
    }

    public ProjetResponse projetWithTaches(Long id) {
        Projets projet = projetsRepository.findById(id)
                .orElse(
                        Projets.builder()
                                .nom("NOT_FOUND")
                                .build()
                );

        List<Taches> taches = tachesClient.findAllTachesByProjet(id);

        return new ProjetResponse.Builder()
                .nom(projet.getNom())
                .dateDebut(projet.getDateDebut())
                .dateFin(projet.getDateFin())
                .description(projet.getDescription())
                .budget(projet.getBudget())
                .taches(taches)
                .build();
    }
}
