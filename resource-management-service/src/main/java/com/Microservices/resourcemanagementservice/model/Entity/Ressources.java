package com.Microservices.resourcemanagementservice.model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Ressources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Double quantity;
    private Long tacheId;

    // No-argument constructor
    public Ressources() {}

    // All-arguments constructor
    public Ressources(Long id, String nom, Double quantity, Long tacheId) {
        this.id = id;
        this.nom = nom;
        this.quantity = quantity;
        this.tacheId = tacheId;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Long getTacheId() {
        return tacheId;
    }

    public void setTacheId(Long tacheId) {
        this.tacheId = tacheId;
    }

    @Override
    public String toString() {
        return "Ressources{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantity=" + quantity +
                ", tacheId=" + tacheId +
                '}';
    }

    // Builder pattern
    public static class Builder {
        private Long id;
        private String nom;
        private Double quantity;
        private Long tacheId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder quantity(Double quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder tacheId(Long tacheId) {
            this.tacheId = tacheId;
            return this;
        }

        public Ressources build() {
            Ressources ressources = new Ressources();
            ressources.id = this.id;
            ressources.nom = this.nom;
            ressources.quantity = this.quantity;
            ressources.tacheId = this.tacheId;
            return ressources;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
