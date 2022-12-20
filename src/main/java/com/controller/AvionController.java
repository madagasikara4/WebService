package com.controller;

import com.models.Avion;
import com.service.AvionService;
import com.service.EntretienService;
import com.service.KilometrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/avions")
public class AvionController {

    @Autowired
    AvionService avionService;
    @Autowired
    KilometrageService kilometrageService;
    @Autowired
    EntretienService entretienService;

    @GetMapping
    private Object getAllAvions(){
        return avionService.getAllAvion();
    }

    @GetMapping("/{avionid}")
    private Object getAvion(@PathVariable("avionid") int vehiculeid)
    {
        return avionService.getAvion(vehiculeid);
    }

    @GetMapping("/{avionid}/kilometrages")
    private Object getAvionKilometrage(@PathVariable("avionid") int vehiculeid)
    {
        return kilometrageService.getAllKilometrageByAvion(vehiculeid);
    }

    @GetMapping("/{avionid}/entretiens")
    private Object getAvionEntretien(@PathVariable("avionid") int vehiculeid)
    {
        return entretienService.getAllEntretienByAvion(vehiculeid);
    }

    @PutMapping()
    private void updateAvion(@RequestBody Avion avion){
        avionService.updateAvion(avion);
    }
}
