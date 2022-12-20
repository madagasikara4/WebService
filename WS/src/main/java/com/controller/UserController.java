package com.controller;

import com.models.Data;
import com.models.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.service.UserService;
import com.models.Utilisateur;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{userid}")
    private Object getUser(@PathVariable("userid") int userid)
    {
        return userService.getUsersById(userid);
    }


    @PostMapping("/login")
    private Object login(@RequestBody Utilisateur user){
        return userService.login(user);
    }

    @PostMapping()
    private int inscription(@RequestBody Utilisateur user){
        userService.saveOrUpdate(user);
        return user.getIdUser();
    }

    @GetMapping()
    private Object getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userid}/{token}")
    private Object isValide(@PathVariable("userid") int userid,@PathVariable("token") String token){
        return userService.isValide(userid,token);
    }

    @DeleteMapping("/{userid}/{token}")
    private void deconnexion(@PathVariable("userid") int userid,@PathVariable("token") String token){
        userService.deconnexion(userid,token);
    }

}
