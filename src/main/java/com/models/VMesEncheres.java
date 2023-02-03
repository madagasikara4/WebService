package com.models;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name="v_mes_encheres")
public class VMesEncheres {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idenchere;
    @Column(name="idproduit")
    private int idproduit;
    @Column(name="idutilisateur")
    private int idutilisateur;
    @Column(name="prix")
    private int prix;
    @Column(name="datemise")
    private Date datemise;
    @Column(name="nomproduit")
    private String nomproduit;
    @Column(name="nomuser")
    private String nomuser;

    public VMesEncheres() {
    }

    public VMesEncheres(int idenchere, int idproduit, int idutilisateur, int prix, Date datemise, String nomproduit, String nomuser) {
        this.idenchere = idenchere;
        this.idproduit = idproduit;
        this.idutilisateur = idutilisateur;
        this.prix = prix;
        this.datemise = datemise;
        this.nomproduit = nomproduit;
        this.nomuser = nomuser;
    }

    public int getIdenchere() {
        return idenchere;
    }

    public void setIdenchere(int idenchere) {
        this.idenchere = idenchere;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDatemise() {
        return datemise;
    }

    public void setDatemise(Date datemise) {
        this.datemise = datemise;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }
}
