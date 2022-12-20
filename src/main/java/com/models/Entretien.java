package com.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "detailavionentretien")
public class Entretien {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "identretien")
    private int identretien;
    @Column(name = "idavion")
    private int idavion;
    @Column(name = "ref")
    private String ref;
    @Column(name = "nom")
    private String nom;
    @Column(name = "photo")
    private String photo;
    @Column(name = "dates")
    private Date dates;
    @Column(name = "description")
    private String description;

    public Entretien() {
    }

    public Entretien(int identretien, int idavion, String ref, String nom, String photo, Date dates, String description) {
        this.identretien = identretien;
        this.idavion = idavion;
        this.ref = ref;
        this.nom = nom;
        this.photo = photo;
        this.dates = dates;
        this.description = description;
    }

    public int getIdentretien() {
        return identretien;
    }

    public void setIdentretien(int identretien) {
        this.identretien = identretien;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
