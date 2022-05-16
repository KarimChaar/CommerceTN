package com.example.bi3wichri.Models;

public class User {
    private int id_U;
    private String nom_U;
    private String prenom_U;
    private String tel_U;
    private String login;
    private String mdp;

    public User(String nom_U, String prenom_U, String tel_U, String login, String mdp) {
        this.nom_U = nom_U;
        this.prenom_U = prenom_U;
        this.tel_U = tel_U;
        this.login = login;
        this.mdp = mdp;
    }

    public User() {
    }

    public int getId_U() {
        return id_U;
    }

    public void setId_U(int id_U) {
        this.id_U = id_U;
    }

    public String getNom_U() {
        return nom_U;
    }

    public void setNom_U(String nom_U) {
        this.nom_U = nom_U;
    }

    public String getPrenom_U() {
        return prenom_U;
    }

    public void setPrenom_U(String prenom_U) {
        this.prenom_U = prenom_U;
    }

    public String getTel_U() {
        return tel_U;
    }

    public void setTel_U(String tel_U) {
        this.tel_U = tel_U;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id_U=" + id_U +
                ", nom_U='" + nom_U + '\'' +
                ", prenom_U='" + prenom_U + '\'' +
                ", tel_U='" + tel_U + '\'' +
                ", login='" + login + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
