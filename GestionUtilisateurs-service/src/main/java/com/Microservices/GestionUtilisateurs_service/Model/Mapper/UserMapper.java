package com.Microservices.GestionUtilisateurs_service.Model.Mapper;


import com.Microservices.GestionUtilisateurs_service.Model.Dto.userDTO;
import com.Microservices.GestionUtilisateurs_service.Model.Entity.user;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    user toEntity(userDTO DTO);
    userDTO toDTO(user entity);
    List<userDTO> toDTOList(List<user> All);
    List<user> toEntityList(List<userDTO> AllDTOs);
}
