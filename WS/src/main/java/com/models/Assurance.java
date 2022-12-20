package com.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "expireassurance")
public class Assurance {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "idassurance")
    private int idassurance;
    @Column(name ="idavion" )
    private int idavion;
    @Column(name = "ref")
    private String ref;
    @Column(name = "nom")
    private String nom;
    @Column(name = "photo")
    private String photo;
    @Column(name = "datedebut")
    private Date datedebut;
    @Column(name = "duree")
    private int duree;
    @Column(name = "expire")
    private int expire;
    @Column(name = "fin")
    private Date fin;

    public Assurance() {
    }

    public Assurance(int idassurance, int idavion, String ref, String nom, String photo, Date datedebut, int duree, int expire, Date fin) {
        this.idassurance = idassurance;
        this.idavion = idavion;
        this.ref = ref;
        this.nom = nom;
        this.photo = photo;
        this.datedebut = datedebut;
        this.duree = duree;
        this.expire = expire;
        this.fin = fin;
    }

    public int getIdassurance() {
        return idassurance;
    }

    public void setIdassurance(int idassurance) {
        this.idassurance = idassurance;
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

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
}
