package com.models;

import javax.persistence.*;

@Entity(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int iduser;

    @Column
    private String identifiant;

    @Column(name = "pwd")
    private String password;


    public Utilisateur(){}

    public Utilisateur(int idUser, String identifiant, String password){
        this.iduser=idUser;
        this.identifiant=identifiant;
        this.password=password;
    }

    public int getIdUser() {
        return iduser;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setIdUser(int iduser) {
        this.iduser = iduser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
