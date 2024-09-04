package com.Microservices.GestionUtilisateurs_service.Model.Mapper;


import com.Microservices.GestionUtilisateurs_service.Model.Dto.UserDTO;
import com.Microservices.GestionUtilisateurs_service.Model.Entity.user;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    user toEntity(UserDTO DTO);
    UserDTO toDTO(user entity);
    List<UserDTO> toDTOList(List<user> All);
    List<user> toEntityList(List<UserDTO> AllDTOs);
}
