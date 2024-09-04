package com.Microservices.GestionUtilisateurs_service.Service;


import com.Microservices.GestionUtilisateurs_service.Model.Dto.UserDTO;
import com.Microservices.GestionUtilisateurs_service.Model.Entity.user;
import com.Microservices.GestionUtilisateurs_service.Model.Mapper.UserMapper;
import com.Microservices.GestionUtilisateurs_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;


    public void deleteUser(Long userId) {
        userRepository.delete(userRepository.findById(userId).get());
    }

    public List<UserDTO> GetAllUser() {
        List<user> users = userRepository.findAll();
        return userMapper.toDTOList(users);
    }
}
