package com.Microservices.projectmanagementservice.model.Dto;



import lombok.Data;

import java.util.Date;

@Data
public class ProjetsDTO {
    private Long id;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Double budget;

    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public Double  getBudget() { return budget; }
    public Date getDateDebut() { return dateDebut; }
    public Date getDateFin() { return dateFin; }
}