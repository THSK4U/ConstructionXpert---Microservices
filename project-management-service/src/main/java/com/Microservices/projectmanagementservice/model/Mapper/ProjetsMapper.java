package com.Microservices.projectmanagementservice.model.Mapper;


import com.Microservices.projectmanagementservice.model.Dto.ProjetsDTO;
import com.Microservices.projectmanagementservice.model.Entity.Projets;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjetsMapper {
    Projets toEntity(ProjetsDTO DTO);
    ProjetsDTO toDTO(Projets entity);
    List<ProjetsDTO> toDTOList(List<Projets> All);
    List<Projets> toEntityList(List<ProjetsDTO> AllDTOs);
}
