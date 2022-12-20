package com.controller;

import com.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/assurances")
public class AssuranceController {

    @Autowired
    AssuranceService assuranceService;

    @GetMapping()
    private Object getAllAssurance() {
        return assuranceService.getAllAssurance();
    }

}
