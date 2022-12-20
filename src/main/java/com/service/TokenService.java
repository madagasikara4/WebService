package com.service;

import com.models.Data;
import com.models.Error;
import com.models.Token;
import com.repository.TokenRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TokenService {
    @Autowired
    TokenRipository repository;

    @Autowired
    ExpirationService expirationService;

    public Object getTokenById(int id)
    {
        try {
            return new Data(this.repository.findById(id).get());
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public Object getAllToken(){
        try {
            List<Token> user = new ArrayList<Token>();
            repository.findAll().forEach(user1 -> user.add(user1));
            return new Data(user);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void saveToken(Token token)
    {
        repository.save(token);
        expirationService.saveExpiration(token);
    }
}
