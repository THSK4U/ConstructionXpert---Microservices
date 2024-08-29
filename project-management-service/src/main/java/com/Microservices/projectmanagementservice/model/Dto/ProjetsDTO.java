package com.Microservices.projectmanagementservice.model.Dto;

import java.util.Date;

public class ProjetsDTO {
    private Long id;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Double budget;

    // No-argument constructor
    public ProjetsDTO() {}

    // All-arguments constructor
    public ProjetsDTO(Long id, String nom, String description, Date dateDebut, Date dateFin, Double budget) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Date getDateDebut() { return dateDebut; }
    public void setDateDebut(Date dateDebut) { this.dateDebut = dateDebut; }
    public Date getDateFin() { return dateFin; }
    public void setDateFin(Date dateFin) { this.dateFin = dateFin; }
    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    @Override
    public String toString() {
        return "ProjetsDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", budget=" + budget +
                '}';
    }

    public static class Builder {
        private Long id;
        private String nom;
        private String description;
        private Date dateDebut;
        private Date dateFin;
        private Double budget;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder nom(String nom) { this.nom = nom; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder dateDebut(Date dateDebut) { this.dateDebut = dateDebut; return this; }
        public Builder dateFin(Date dateFin) { this.dateFin = dateFin; return this; }
        public Builder budget(Double budget) { this.budget = budget; return this; }

        public ProjetsDTO build() {
            ProjetsDTO projetsDTO = new ProjetsDTO();
            projetsDTO.id = this.id;
            projetsDTO.nom = this.nom;
            projetsDTO.description = this.description;
            projetsDTO.dateDebut = this.dateDebut;
            projetsDTO.dateFin = this.dateFin;
            projetsDTO.budget = this.budget;
            return projetsDTO;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
