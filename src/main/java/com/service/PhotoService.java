package com.service;

import com.models.Data;
import com.models.Photo;
import com.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    public Object getPhotoByidProduit(int idProduit){
        try{
            Object obj=photoRepository.findPhotoByIdproduit(idProduit);
            return new Data(obj);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void save(Photo p){
        photoRepository.save(p);
    }
}
