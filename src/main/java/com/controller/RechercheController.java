package com.controller;


import com.models.RechercheAvance;
import com.service.RechercheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/recherche")
public class RechercheController {

    @Autowired
    RechercheService rechercheService;

    @PostMapping()
    private Object getRecherche(@RequestBody RechercheAvance rec){
        return rechercheService.rechercheAvance(rec);
    }
}
