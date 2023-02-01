package com.service;

import com.controller.PhotoController;
import com.controller.ProduitController;
import com.models.Data;
import com.models.Photo;
import com.models.Produit;
import com.models.ProduitPhoto;
import com.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class ProduitPhotoService {

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    ProduitService produitService;

    @Autowired
    PhotoService photoService;

    public Object getAllProduitPhoto(){
        try{
            List<Produit> produit = new ArrayList<Produit>();
            produitRepository.findAll().forEach(produit1 -> produit.add(produit1));
            List<ProduitPhoto> val=new ArrayList<ProduitPhoto>();
            for (int i = 0; i < produit.size(); i++) {
                val.add(new ProduitPhoto(produit.get(i), photoService.getPhotoByid(produit.get(i).getIdproduit())));
            }
            return new Data(val);
        }catch (Exception e){
            return new Error(e);
        }
    }

    public Object ajoutProduitPhoto(ProduitPhoto pp){
        try{
            Produit produit=pp.toProduit();
            if(produit.getDebut()==null){
                Calendar cl=Calendar.getInstance();
                produit.setDebut(cl.getTime());
            }
            produitService.saveOrUpdate(produit);
            int id=produit.getIdproduit();

            Photo pho=pp.toPhoto(id);
            photoService.save(pho);
            return new Data(id);
        }
        catch (Exception e){
            return new Error(e);
        }
    }
}
