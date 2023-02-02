package com.controller;

import com.models.Produit;
import com.models.ProduitPhoto;
import com.service.ProduitPhotoService;
import com.service.ProduitService;
import com.service.VProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
@CrossOrigin
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @Autowired
    VProduitService vProduitService;

    @Autowired
    ProduitPhotoService produitPhotoService;

    @GetMapping()
    private Object getAllVProduit() {
        return vProduitService.getAllVProduit();
    }

    @GetMapping("/photo")
    private Object getAllVProduitPhoto() {
        return produitPhotoService.getAllProduitPhoto();
    }

    @GetMapping("/photo/{iduser}")
    private Object getAllVProduitPhotoByIduser(@PathVariable("iduser") int iduser) {
        return produitPhotoService.getAllProduitPhotoByiduser(iduser);
    }

    @GetMapping("/{idproduit}/photo")
    private Object getAllVProduitPhotoByProduit(@PathVariable("idproduit") int idproduit) {
        return produitPhotoService.getAllProduitPhotoByidProduit(idproduit);
    }

    @GetMapping("/photo/statut")
    private Object getAllVProduitPhotoByStatut() {
        return produitPhotoService.getAllProduitPhotoByStatut(0);
    }


    @GetMapping("/{produitid}")
    private Object getVProduit(@PathVariable("produitid") int produitid)
    {
        return vProduitService.getVProduitById(produitid);
    }

    @GetMapping("/users/{iduser}")
    private Object getVProduitByIdUser(@PathVariable("iduser") int iduser){
        return vProduitService.getAllVProduitByIdutilisateur(iduser);
    }

    @GetMapping("/bycategorie/{categorieid}")
    private Object getValideProduitByCategorie(@PathVariable("categorieid") int categorieid)
    {
        return vProduitService.getValideByCategorie(categorieid);
    }

    @PostMapping()
    public int saveProduit(@RequestBody Produit produit){
        if(produit.getDebut()==null){
            Calendar cl=Calendar.getInstance();
            produit.setDebut(cl.getTime());
        }
        produitService.saveOrUpdate(produit);
        return produit.getIdproduit();
    }

    @PostMapping("/photo")
    public Object addProduitPhoto(ProduitPhoto pp){
        return produitPhotoService.ajoutProduitPhoto(pp);
    }

    @DeleteMapping("/{produitid}")
    private void deleteProduit(@PathVariable("produitid") int produitid)
    {
        produitService.delete(produitid);
    }

    @GetMapping("/find/{produitid}")
    private Object findById(@PathVariable("produitid") int produitid)
    {
        return produitService.getProduitById(produitid);
    }

    @PutMapping()
    private void update(@RequestBody Produit produit)
    {
        produitService.saveOrUpdate(produit);
    }

    @GetMapping("/terminer")
    private void termineProduit(){
        produitService.terminerEnchere();
    }


}
