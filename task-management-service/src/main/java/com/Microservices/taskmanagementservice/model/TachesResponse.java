package com.Microservices.taskmanagementservice.model;

import com.Microservices.taskmanagementservice.model.Entity.Ressources;
import com.Microservices.taskmanagementservice.model.Entity.Statut;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TachesResponse {
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Statut statut;
    private List<Ressources> ressources;
}