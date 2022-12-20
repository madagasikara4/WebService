package com.models;

import javax.persistence.*;

@Entity(name = "avion")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idavion")
    private int idavion;
    @Column(name = "ref")
    private String ref;
    @Column(name = "nom")
    private String nom;
    @Column(name = "photo")
    private byte[] photo;

    public Avion(){}

    public Avion(int idavion, String ref, String nom, byte[] photo) {
        this.idavion = idavion;
        this.ref = ref;
        this.nom = nom;
        this.photo = photo;
    }

    public int getIdavion() {
        return idavion;
    }

    public void setIdavion(int idavion) {
        this.idavion = idavion;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
