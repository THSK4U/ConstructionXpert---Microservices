package com.Microservices.taskmanagementservice.model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Taches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Statut statut;
    private Long projetId;

    // No-argument constructor
    public Taches() {
    }

    // All-argument constructor
    public Taches(Long id, String description, Date dateDebut, Date dateFin, Statut statut, Long projetId) {
        this.id = id;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.projetId = projetId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public Long getProjetId() {
        return projetId;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
    }

    // Builder pattern implementation
    public static TachesBuilder builder() {
        return new TachesBuilder();
    }

    public static class TachesBuilder {
        private Long id;
        private String description;
        private Date dateDebut;
        private Date dateFin;
        private Statut statut;
        private Long projetId;

        public TachesBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TachesBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TachesBuilder dateDebut(Date dateDebut) {
            this.dateDebut = dateDebut;
            return this;
        }

        public TachesBuilder dateFin(Date dateFin) {
            this.dateFin = dateFin;
            return this;
        }

        public TachesBuilder statut(Statut statut) {
            this.statut = statut;
            return this;
        }

        public TachesBuilder projetId(Long projetId) {
            this.projetId = projetId;
            return this;
        }

        public Taches build() {
            return new Taches(id, description, dateDebut, dateFin, statut, projetId);
        }
    }

}
