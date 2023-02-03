package com.controller;

import com.models.RechercheAvance;
import com.models.VEncherePrixMax;
import com.service.RechercheService;
import com.service.VEncherePrixMaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/prixMax")
public class PrixMaxController {
    @Autowired
    VEncherePrixMaxService vEncherePrixMaxService;

    @GetMapping("/{idproduit}")
    private Object getPrixMax(@PathVariable("idproduit") int idproduit){
        return vEncherePrixMaxService.findById(idproduit);
    }
}
