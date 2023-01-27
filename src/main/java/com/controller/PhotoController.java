package com.controller;

import com.models.Photo;
import com.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/{idproduit}")
    private Object getVProduit(@PathVariable("idproduit") int produitid) {
        return photoService.getPhotoByidProduit(produitid);
    }

    @PostMapping()
    private void addPhoto(@RequestBody Photo photo){
        photoService.save(photo);
    }

    @PutMapping()
    private void updatePhoto(@RequestBody Photo photo){
        photoService.save(photo);
    }
}
