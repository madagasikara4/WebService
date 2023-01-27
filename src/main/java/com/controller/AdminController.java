package com.controller;


import com.models.Admin;
import com.models.Categorie;
import com.models.Data;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    private Object login(@RequestBody Admin adm){
        try{
            return new Data(adminService.login(adm));
        }
        catch (Exception e){
            return new Error(e);
        }
    }
}
