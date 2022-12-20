package com.service;

import com.models.Data;
import com.models.Error;
import com.models.Expiration;
import com.models.Token;
import com.repository.ExpirationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpirationService {

    @Autowired
    ExpirationRepository repository;

    public Object getExpirationById(String token)
    {
        try {
            List<Expiration> expiration = new ArrayList<Expiration>();
            repository.findAll().forEach(user1 -> expiration.add(user1));

            for (int i = 0; i < expiration.size(); i++) {
                if (expiration.get(i).getIdtoken().compareTo(token) == 0)
                    return new Data(expiration.get(i));
            }
            return new Data(null);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public Object getAllExpiration(){
        try {
            List<Expiration> user = new ArrayList<Expiration>();
            repository.findAll().forEach(user1 -> user.add(user1));
            return new Data(user);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void update(Expiration exp){
        repository.save(exp);
    }

    public void saveExpiration(Token Token)
    {
        Expiration exp=new Expiration(Token);
        repository.save(exp);
    }
}
