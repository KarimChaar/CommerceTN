package com.example.bi3wichri.Models;

public class Produit {
    private int id_P;
    private String nom_P;
    private String prix_P;
    private String description_P;
    private String categorie_P;

    public Produit(int id_P, String nom_P, String prix_P, String description_P, String categorie_P) {
        this.id_P = id_P;
        this.nom_P = nom_P;
        this.prix_P = prix_P;
        this.description_P = description_P;
        this.categorie_P = categorie_P;
    }

    public Produit() {
    }

    public Produit(String nomP, String prixP, String description_p, String catP) {
    }

    public int getId_P() {
        return id_P;
    }

    public void setId_P(int id_P) {
        this.id_P = id_P;
    }

    public String getNom_P() {
        return nom_P;
    }

    public void setNom_P(String nom_P) {
        this.nom_P = nom_P;
    }

    public String getPrix_P() {
        return prix_P;
    }

    public void setPrix_P(String prix_P) {
        this.prix_P = prix_P;
    }

    public String getDescription_P() {
        return description_P;
    }

    public void setDescription_P(String description_P) {
        this.description_P = description_P;
    }

    public String getCategorie_P() {
        return categorie_P;
    }

    public void setCategorie_P(String categorie_P) {
        this.categorie_P = categorie_P;
    }

    @Override
    public String toString() {
        return "Produits{" +
                "id_P=" + id_P +
                ", nom_P='" + nom_P + '\'' +
                ", prix_P=" + prix_P +
                ", description_P='" + description_P + '\'' +
                ", categorie_P='" + categorie_P + '\'' +
                '}';
    }
}
