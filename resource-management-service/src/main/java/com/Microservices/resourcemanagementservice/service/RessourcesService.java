package com.Microservices.resourcemanagementservice.service;


import com.Microservices.resourcemanagementservice.model.Dto.RessourcesDTO;
import com.Microservices.resourcemanagementservice.model.Entity.Ressources;
import com.Microservices.resourcemanagementservice.model.Mapper.RessourcesMapper;
import com.Microservices.resourcemanagementservice.repository.RessourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RessourcesService {


    @Autowired
    private RessourcesMapper mapper;

    @Autowired
    private RessourcesRepository Repository;

    public List<Ressources> getAllRessourcesByTaches(Long id) {
        return Repository.getRessourcesByTacheId(id);
    }


    public List<RessourcesDTO> getAllRessources() {
        List<Ressources> Taches = Repository.findAll();
        System.out.println("find"+Taches);
        return Taches.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public RessourcesDTO getRessourcesById(Long id) {
        return Repository.findById(id)
                .map(mapper::toDTO).orElse(null);
    }

    public RessourcesDTO createRessources(RessourcesDTO ressourcesDTO) {
        Ressources tachesEntity = mapper.toEntity(ressourcesDTO);
        Ressources savedTaches = Repository.save(tachesEntity);
        return mapper.toDTO(savedTaches);
    }

    public RessourcesDTO updateRessources(Long id, RessourcesDTO ressourcesDTO) {
        Optional<Ressources> optional = Repository.findById(id);
        if (optional.isPresent()) {
            Ressources taches = optional.get();
            taches.setNom(ressourcesDTO.getNom());
            taches.setQuantity(ressourcesDTO.getQuantity());


            Ressources savedTaches = Repository.save(taches);
            return mapper.toDTO(savedTaches);
        } else {
            return null;
        }
    }

    public void deleteRessources(Long id) {
        Repository.deleteById(id);
    }


}
