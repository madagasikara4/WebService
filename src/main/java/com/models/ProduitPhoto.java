package com.models;

import javax.persistence.Column;
import java.util.Date;

public class ProduitPhoto {

    private int idproduit;

    private String nomproduit;

    private int idutilisateur;

    private int idcategorie;

    private String descri;

    private int prixenchere;

    private int prixmin;

    private int duree;

    private Date debut;

    private int statut;
    private String[] image;

    public ProduitPhoto(int idproduit, String nomproduit, int idutilisateur, int idcategorie, String descri, int prixenchere, int prixmin, int duree, Date debut, int statut, String[] image) {
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.idutilisateur = idutilisateur;
        this.idcategorie = idcategorie;
        this.descri = descri;
        this.prixenchere = prixenchere;
        this.prixmin = prixmin;
        this.duree = duree;
        this.debut = debut;
        this.statut = statut;
        this.image = image;
    }

    public ProduitPhoto() {
    }

    public Produit toProduit(){
        Produit pro= new Produit();
        pro.setNomproduit(this.nomproduit);
        pro.setStatut(this.statut);
        pro.setDebut(this.debut);
        pro.setDescri(this.descri);
        pro.setDuree(this.duree);
        pro.setIdcategorie(this.idcategorie);
        pro.setPrixenchere(this.prixenchere);
        pro.setPrixmin(this.prixmin);
        pro.setIdUtilisateur(this.idutilisateur);
        return pro;
    }

    public Photo toPhoto(int idproduit){
        Photo p=new Photo();
        p.setImage(this.image);
        p.setIdproduit(idproduit);
        return p;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public int getPrixenchere() {
        return prixenchere;
    }

    public void setPrixenchere(int prixenchere) {
        this.prixenchere = prixenchere;
    }

    public int getPrixmin() {
        return prixmin;
    }

    public void setPrixmin(int prixmin) {
        this.prixmin = prixmin;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
    }
}
