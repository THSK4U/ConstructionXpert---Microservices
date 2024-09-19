package com.Microservices.taskmanagementservice.service;

import com.Microservices.taskmanagementservice.model.Dto.TachesDTO;
import com.Microservices.taskmanagementservice.model.Entity.Statut;
import com.Microservices.taskmanagementservice.model.Entity.Taches;
import com.Microservices.taskmanagementservice.model.Mapper.TachesMapper;
import com.Microservices.taskmanagementservice.repository.TachesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TachesServiceTest {

    @Mock
    private TachesRepository tachesRepository;

    @Mock
    private TachesMapper mapper;

    @InjectMocks
    private TachesService tachesService;

    public TachesServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTachesByProjet() {
        Long projetId = 1L;
        Taches tache = new Taches();

        when(tachesRepository.findAllByProjetId(projetId)).thenReturn(Collections.singletonList(tache));

        // select Methode de test
        List<Taches> tachesList = tachesService.getAllTachesByProjet(projetId);

        // Vérifier que tachesList n'est pas vide
        assertNotNull(tachesList);
        assertEquals(1, tachesList.size());

        verify(tachesRepository, times(1)).findAllByProjetId(projetId);
    }

    @Test
    void getAllTaches() {
        Taches tache = new Taches();

        when(tachesRepository.findAll()).thenReturn(Collections.singletonList(tache));

        List<TachesDTO> tachesList = tachesService.getAllTaches();

        assertNotNull(tachesList);

        verify(tachesRepository, times(1)).findAll();
    }
    @Test
    void getTachesById() {
        Long tacheId = 1L;
        Taches tache = new Taches();
        tache.setId(tacheId);

        TachesDTO expectedDto = new TachesDTO();
        expectedDto.setId(tacheId);

        when(tachesRepository.findById(tacheId)).thenReturn(Optional.of(tache));
        when(mapper.toDTO(tache)).thenReturn(expectedDto);

        TachesDTO retrievedTache = tachesService.getTachesById(tacheId);

        assertNotNull(retrievedTache);
        assertEquals(tacheId, retrievedTache.getId());

        verify(tachesRepository, times(1)).findById(tacheId);
        verify(mapper, times(1)).toDTO(tache);
    }

    @Test
    void createTaches() {
        TachesDTO tacheDTO = new TachesDTO();
        Taches tache = new Taches();

        when(mapper.toEntity(tacheDTO)).thenReturn(tache);
        when(tachesRepository.save(tache)).thenReturn(tache);
        when(mapper.toDTO(tache)).thenReturn(tacheDTO);

        TachesDTO created = tachesService.createTaches(tacheDTO);

        assertNotNull(created);
        assertEquals(tacheDTO, created);
        verify(mapper, times(1)).toEntity(tacheDTO);
        verify(tachesRepository, times(1)).save(tache);
        verify(mapper, times(1)).toDTO(tache);
    }

    @Test
    void updateTaches() {
        Long tacheId = 1L;
        Taches tache = new Taches();
        tache.setId(tacheId);
        tache.setStatut(Statut.A_FAIRE);

        TachesDTO tacheDTO = new TachesDTO();
        tacheDTO.setId(tacheId);
        tacheDTO.setStatut(Statut.A_FAIRE);

        when(tachesRepository.findById(tacheId)).thenReturn(Optional.of(tache));
        when(tachesRepository.save(any(Taches.class))).thenReturn(tache);
        when(mapper.toDTO(any(Taches.class))).thenReturn(tacheDTO);

        TachesDTO updatedTache = tachesService.updateTaches(tacheId, tacheDTO);

        assertNotNull(updatedTache);
        assertEquals(Statut.A_FAIRE, updatedTache.getStatut());
        verify(tachesRepository, times(1)).findById(tacheId);
        verify(tachesRepository, times(1)).save(any(Taches.class));
    }

    @Test
    void deleteTaches() {
        Long tacheId = 1L;

        tachesService.deleteTaches(tacheId);

        verify(tachesRepository, times(1)).deleteById(tacheId);
    }

}