package com.Microservices.taskmanagementservice.model.Entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ressources {
    private String nom;
    private Double quantity;

    // No-argument constructor
    public Ressources() {
    }

    // All-argument constructor
    public Ressources(String nom, Double quantity) {
        this.nom = nom;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    // Builder pattern implementation
    public static RessourcesBuilder builder() {
        return new RessourcesBuilder();
    }

    public static class RessourcesBuilder {
        private String nom;
        private Double quantity;

        public RessourcesBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public RessourcesBuilder quantity(Double quantity) {
            this.quantity = quantity;
            return this;
        }

        public Ressources build() {
            return new Ressources(nom, quantity);
        }
    }
}