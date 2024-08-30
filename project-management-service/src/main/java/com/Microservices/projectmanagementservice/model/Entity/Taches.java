package com.Microservices.projectmanagementservice.model.Entity;


import java.util.Date;

public class Taches {

    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Statut statut;

    // No-argument constructor
    public Taches() {
    }

    // All-argument constructor
    public Taches(String description, Date dateDebut, Date dateFin, Statut statut) {
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
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

    // Override toString method
    @Override
    public String toString() {
        return "Taches{" +
                "description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", statut=" + statut +
                '}';
    }



}
