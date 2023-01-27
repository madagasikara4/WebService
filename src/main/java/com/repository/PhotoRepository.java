package com.repository;

import com.models.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo,String> {

    public Photo findPhotoByIdproduit(int idproduit);
}
