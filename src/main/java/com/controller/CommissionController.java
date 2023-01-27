package com.controller;

import com.models.Commission;
import com.service.CommissionService;

import javax.xml.ws.RequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/commission")
public class CommissionController {

    @Autowired
    CommissionService commissionService;

    @GetMapping
    private Object getAllCommission(){return commissionService.getAllCommission();}

    @GetMapping("/{idcommisssion}")
    private Object getAllCommission(@PathVariable("idcommisssion") int idcommission ){
        System.out.println("tafa");
        return commissionService.getCommission(idcommission);
    }

    @PutMapping
    private void updateCommission(@RequestBody Commission commission){
        commissionService.updateCommission(commission);
    }
}
