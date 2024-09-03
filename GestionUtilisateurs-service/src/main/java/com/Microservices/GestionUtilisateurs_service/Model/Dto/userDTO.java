
package com.Microservices.GestionUtilisateurs_service.Model.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class userDTO {

    private Long id;
    private String username;
    private String password;
    private String role;

    // Getters and Setters
}

