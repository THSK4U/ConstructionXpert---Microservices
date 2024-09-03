package com.Microservices.resourcemanagementservice.model.Mapper;


import com.Microservices.resourcemanagementservice.model.Dto.RessourcesDTO;
import com.Microservices.resourcemanagementservice.model.Entity.Ressources;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RessourcesMapper {
    Ressources toEntity(RessourcesDTO DTO);
    RessourcesDTO toDTO(Ressources entity);
    List<RessourcesDTO> toDTOList(List<Ressources> All);
    List<Ressources> toEntityList(List<RessourcesDTO> AllDTOs);
}
