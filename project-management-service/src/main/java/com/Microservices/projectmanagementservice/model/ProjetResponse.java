package com.Microservices.projectmanagementservice.model;

import com.Microservices.projectmanagementservice.model.Entity.Taches;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetResponse {
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Double budget;
    private List<Taches> taches;

    // Private constructor for builder
    private ProjetResponse(Builder builder) {
        this.nom = builder.nom;
        this.description = builder.description;
        this.dateDebut = builder.dateDebut;
        this.dateFin = builder.dateFin;
        this.budget = builder.budget;
        this.taches = builder.taches;
    }

    // Static Builder class
    public static class Builder {
        private String nom;
        private String description;
        private Date dateDebut;
        private Date dateFin;
        private Double budget;
        private List<Taches> taches;

        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder dateDebut(Date dateDebut) {
            this.dateDebut = dateDebut;
            return this;
        }

        public Builder dateFin(Date dateFin) {
            this.dateFin = dateFin;
            return this;
        }

        public Builder budget(Double budget) {
            this.budget = budget;
            return this;
        }

        public Builder taches(List<Taches> taches) {
            this.taches = taches;
            return this;
        }

        public ProjetResponse build() {
            return new ProjetResponse(this);
        }
    }

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public List<Taches> getTaches() {
        return taches;
    }

    public void setTaches(List<Taches> taches) {
        this.taches = taches;
    }
}
