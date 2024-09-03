package com.Microservices.resourcemanagementservice.model.Dto;

public class RessourcesDTO {
    private Long id;
    private String nom;
    private Double quantity;
    private Long tacheId;

    // No-argument constructor
    public RessourcesDTO() {}

    // All-arguments constructor
    public RessourcesDTO(Long id, String nom, Double quantity, Long tacheId) {
        this.id = id;
        this.nom = nom;
        this.quantity = quantity;
        this.tacheId = tacheId;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public Long getTacheId() { return tacheId; }
    public void setTacheId(Long tacheId) { this.tacheId = tacheId; }

    @Override
    public String toString() {
        return "RessourcesDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantity=" + quantity +
                ", tacheId=" + tacheId +
                '}';
    }

    public static class Builder {
        private Long id;
        private String nom;
        private Double quantity;
        private Long tacheId;

        public Builder id(Long id) { this.id = id; return this; }
        public Builder nom(String nom) { this.nom = nom; return this; }
        public Builder quantity(Double quantity) { this.quantity = quantity; return this; }
        public Builder tacheId(Long tacheId) { this.tacheId = tacheId; return this; }

        public RessourcesDTO build() {
            RessourcesDTO ressourcesDTO = new RessourcesDTO();
            ressourcesDTO.id = this.id;
            ressourcesDTO.nom = this.nom;
            ressourcesDTO.quantity = this.quantity;
            ressourcesDTO.tacheId = this.tacheId;
            return ressourcesDTO;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
