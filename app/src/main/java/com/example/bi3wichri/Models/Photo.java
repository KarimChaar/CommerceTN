package com.example.bi3wichri.Models;

public class Photo {
    private int id_pho;
    private String nom_pho;
    private String photo;

    public Photo(String nom_pho, String photo) {
        this.nom_pho = nom_pho;
        this.photo = photo;
    }

    public int getId_pho() {
        return id_pho;
    }

    public void setId_pho(int id_pho) {
        this.id_pho = id_pho;
    }

    public String getNom_pho() {
        return nom_pho;
    }

    public void setNom_pho(String nom_pho) {
        this.nom_pho = nom_pho;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Photos{" +
                "id_pho=" + id_pho +
                ", nom_pho='" + nom_pho + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
