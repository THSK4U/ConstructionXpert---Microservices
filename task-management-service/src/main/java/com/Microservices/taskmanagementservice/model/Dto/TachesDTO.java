package com.Microservices.taskmanagementservice.model.Dto;

import com.Microservices.taskmanagementservice.model.Entity.Statut;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
public class TachesDTO {

    private Long id;
    private String description;
    private java.sql.Date dateDebut;
    private Date dateFin;
    private Statut statut;
    private Long projetId;

    // No-argument constructor
    public TachesDTO() {
    }

    // All-argument constructor
    public TachesDTO(Long id, String description, Date dateDebut, Date dateFin, Statut statut, Long projetId) {
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
    public static TachesDTOBuilder builder() {
        return new TachesDTOBuilder();
    }

    public static class TachesDTOBuilder {
        private Long id;
        private String description;
        private Date dateDebut;
        private Date dateFin;
        private Statut statut;
        private Long projetId;

        public TachesDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TachesDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TachesDTOBuilder dateDebut(Date dateDebut) {
            this.dateDebut = dateDebut;
            return this;
        }

        public TachesDTOBuilder dateFin(Date dateFin) {
            this.dateFin = dateFin;
            return this;
        }

        public TachesDTOBuilder statut(Statut statut) {
            this.statut = statut;
            return this;
        }

        public TachesDTOBuilder projetId(Long projetId) {
            this.projetId = projetId;
            return this;
        }

        public TachesDTO build() {
            return new TachesDTO(id, description, dateDebut, dateFin, statut, projetId);
        }
    }
}