package com.repository;

import com.models.VProduit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VProduitRepository  extends CrudRepository<VProduit, Integer> {
    List<VProduit> getVProduitByIdutilisateur(int idutilisateur);
    List<VProduit> getVProduitByStatut(int statut);
}
