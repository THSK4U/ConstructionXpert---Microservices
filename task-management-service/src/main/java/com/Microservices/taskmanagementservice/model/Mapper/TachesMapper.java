package com.Microservices.taskmanagementservice.model.Mapper;

import com.Microservices.taskmanagementservice.model.Dto.TachesDTO;
import com.Microservices.taskmanagementservice.model.Entity.Taches;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TachesMapper {
    Taches toEntity(TachesDTO DTO);
    TachesDTO toDTO(Taches entity);
    List<TachesDTO> toDTOList(List<Taches> All);
    List<Taches> toEntityList(List<TachesDTO> AllDTOs);
}
