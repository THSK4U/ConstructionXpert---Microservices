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
    private TachesClient tachesClient;

    @Autowired
    private ProjetsMapper mapper;

    @Autowired
    private ProjetsRepository projetsRepository;

    public List<ProjetsDTO> getAllProjects() {
        List<Projets> projets = projetsRepository.findAll();
        System.out.println("find"+projets);
        return projets.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProjetsDTO getProjectById(Long id) {
        return projetsRepository.findById(id)
                .map(mapper::toDTO).orElse(null);
    }

    public ProjetsDTO createProject(ProjetsDTO projectDTO) {
        Projets projectEntity = mapper.toEntity(projectDTO);
        Projets savedProjets = projetsRepository.save(projectEntity);
        return mapper.toDTO(savedProjets);
    }

    public ProjetsDTO updateProject(Long id, ProjetsDTO projectDTO) {
        Optional<Projets> optional = projetsRepository.findById(id);
        if (optional.isPresent()) {
            Projets projets = optional.get();
            projets.setNom(projectDTO.getNom());
            projets.setDescription(projectDTO.getDescription());
            projets.setBudget(projectDTO.getBudget());
            projets.setDateDebut(projectDTO.getDateDebut());
            projets.setDateFin(projectDTO.getDateFin());

            Projets savedProjets = projetsRepository.save(projets);
            return mapper.toDTO(savedProjets);
        } else {
            return null;
        }
    }

    public void deleteProject(Long id) {
        projetsRepository.deleteById(id);
    }

    public ProjetResponse projetWithTaches(Long id) {
        Projets projet = projetsRepository.findById(id)
                .orElse(new Projets(null, "NOT_FOUND", null, null, null, null));
         System.out.println("ID = " + id);

        List<Taches> taches = tachesClient.findAllTachesByProjet(id);
        ProjetResponse.Builder builder = new ProjetResponse.Builder();
        builder.nom(projet.getNom())
                .description(projet.getDescription())
                .dateDebut(projet.getDateDebut())
                .dateFin(projet.getDateFin())
                .budget(projet.getBudget())
                .taches(taches);
        return builder.build();
    }

}
