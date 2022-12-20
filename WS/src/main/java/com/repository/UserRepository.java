package com.repository;

import com.models.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Utilisateur,Integer> {
}
