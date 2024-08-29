package com.Microservices.projectmanagementservice.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taches {
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Statut statut;
}
