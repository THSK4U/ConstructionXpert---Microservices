package com.Microservices.projectmanagementservice.model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

import java.util.Date;

@Entity
public class Projets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Double budget;

    // No-argument constructor
    public Projets() {}

    // All-arguments constructor
    public Projets(Long id, String nom, String description, Date dateDebut, Date dateFin, Double budget) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.budget = budget;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Projets{" +
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

        public Projets build() {
            Projets projets = new Projets();
            projets.id = this.id;
            projets.nom = this.nom;
            projets.description = this.description;
            projets.dateDebut = this.dateDebut;
            projets.dateFin = this.dateFin;
            projets.budget = this.budget;
            return projets;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}