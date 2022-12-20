package com.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "detailavionkilometrage")
public class Kilometrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idkilometrage" )
    private int idkilometrage;
    @Column(name = "idavion")
    private int idavion;
    @Column(name = "ref")
    private String ref;
    @Column(name = "nom")
    private String nom;
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "datedepart")
    private Date datedepart;
    @Column(name = "debutkm")
    private int debutkm;
    @Column(name = "datearrive")
    private Date datearrive;
    @Column(name = "finkm")
    private int finkm;

    public Kilometrage() {
    }

    public Kilometrage(int idkilometrage, int idavion, String ref, String nom, byte[] photo, Date datedepart, int debutkm, Date datearrive, int finkm) {
        this.idkilometrage = idkilometrage;
        this.idavion = idavion;
        this.ref = ref;
        this.nom = nom;
        this.photo = photo;
        this.datedepart = datedepart;
        this.debutkm = debutkm;
        this.datearrive = datearrive;
        this.finkm = finkm;
    }

    public int getIdkilometrage() {
        return idkilometrage;
    }

    public void setIdkilometrage(int idkilometrage) {
        this.idkilometrage = idkilometrage;
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

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }

    public int getDebutkm() {
        return debutkm;
    }

    public void setDebutkm(int debutkm) {
        this.debutkm = debutkm;
    }

    public Date getDatearrive() {
        return datearrive;
    }

    public void setDatearrive(Date datearrive) {
        this.datearrive = datearrive;
    }

    public int getFinkm() {
        return finkm;
    }

    public void setFinkm(int finkm) {
        this.finkm = finkm;
    }
}
