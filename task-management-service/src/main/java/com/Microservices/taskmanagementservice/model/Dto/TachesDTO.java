package com.Microservices.taskmanagementservice.model.Dto;

import com.Microservices.taskmanagementservice.model.Entity.Statut;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TachesDTO {

    private Long id;
    private String description;
    private java.sql.Date dateDebut;
    private Date dateFin;
    private Statut statut;
    private Long projetId;
}