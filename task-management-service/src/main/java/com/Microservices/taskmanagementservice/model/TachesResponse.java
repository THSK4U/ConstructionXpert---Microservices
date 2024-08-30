package com.Microservices.taskmanagementservice.model;

import com.Microservices.taskmanagementservice.model.Entity.Ressources;
import com.Microservices.taskmanagementservice.model.Entity.Statut;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class TachesResponse {
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Statut statut;
    private List<Ressources> ressources;

    // No-argument constructor
    public TachesResponse() {
    }

    // All-argument constructor
    public TachesResponse(String description, Date dateDebut, Date dateFin, Statut statut, List<Ressources> ressources) {
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.ressources = ressources;
    }

    // Getters and Setters
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

    public List<Ressources> getRessources() {
        return ressources;
    }

    public void setRessources(List<Ressources> ressources) {
        this.ressources = ressources;
    }

    // Builder pattern implementation
    public static TachesResponseBuilder builder() {
        return new TachesResponseBuilder();
    }

    public static class TachesResponseBuilder {
        private String description;
        private Date dateDebut;
        private Date dateFin;
        private Statut statut;
        private List<Ressources> ressources;

        public TachesResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TachesResponseBuilder dateDebut(Date dateDebut) {
            this.dateDebut = dateDebut;
            return this;
        }

        public TachesResponseBuilder dateFin(Date dateFin) {
            this.dateFin = dateFin;
            return this;
        }

        public TachesResponseBuilder statut(Statut statut) {
            this.statut = statut;
            return this;
        }

        public TachesResponseBuilder ressources(List<Ressources> ressources) {
            this.ressources = ressources;
            return this;
        }

        public TachesResponse build() {
            return new TachesResponse(description, dateDebut, dateFin, statut, ressources);
        }
    }
}