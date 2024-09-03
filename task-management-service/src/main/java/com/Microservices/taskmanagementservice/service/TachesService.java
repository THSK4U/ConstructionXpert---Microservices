package com.Microservices.taskmanagementservice.service;


import com.Microservices.taskmanagementservice.client.RessourcesClient;
import com.Microservices.taskmanagementservice.model.Dto.TachesDTO;
import com.Microservices.taskmanagementservice.model.Entity.Ressources;
import com.Microservices.taskmanagementservice.model.Entity.Taches;
import com.Microservices.taskmanagementservice.model.Mapper.TachesMapper;
import com.Microservices.taskmanagementservice.model.TachesResponse;
import com.Microservices.taskmanagementservice.repository.TachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TachesService {

    @Autowired
    private RessourcesClient ressourcesclient;

    @Autowired
    private TachesMapper mapper;

    @Autowired
    private TachesRepository TachesRepository;

    public List<Taches> getAllTachesByProjet(Long id) {
        return TachesRepository.findAllByProjetId(id);
    }

    public List<TachesDTO> getAllTaches() {
        List<Taches> Taches = TachesRepository.findAll();
        System.out.println("find"+Taches);
        return Taches.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public TachesDTO getTachesById(Long id) {
        return TachesRepository.findById(id)
                .map(mapper::toDTO).orElse(null);
    }

    public TachesDTO createTaches(TachesDTO tachesDTO) {
        Taches tachesEntity = mapper.toEntity(tachesDTO);
        Taches savedTaches = TachesRepository.save(tachesEntity);
        return mapper.toDTO(savedTaches);
    }

    public TachesDTO updateTaches(Long id, TachesDTO tachesDTO) {
        Optional<Taches> optional = TachesRepository.findById(id);
        if (optional.isPresent()) {
            Taches taches = optional.get();
            taches.setStatut(tachesDTO.getStatut());
            taches.setDescription(tachesDTO.getDescription());
            taches.setDateDebut(tachesDTO.getDateDebut());
            taches.setDateFin(tachesDTO.getDateFin());

            Taches savedTaches = TachesRepository.save(taches);
            return mapper.toDTO(savedTaches);
        } else {
            return null;
        }
    }

    public void deleteTaches(Long id) {
        TachesRepository.deleteById(id);
    }

    public TachesResponse tachesWithressours(Long id) {
        Taches tache = TachesRepository.findById(id)
                .orElse(new Taches(null, "NOT_FOUND", null, null, null, null));

        List<Ressources> ressources = ressourcesclient.findressourcesByTache(id);

        return TachesResponse.builder()
                .description(tache.getDescription())
                .dateDebut(tache.getDateDebut())
                .dateFin(tache.getDateFin())
                .statut(tache.getStatut())
                .ressources(ressources)
                .build();
    }

}
