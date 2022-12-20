package com.service;

import com.models.Data;
import com.models.Error;
import com.models.Expiration;
import com.models.Token;
import com.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.UserRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    @Autowired
    TokenService token;

    @Autowired
    ExpirationService expiration;

    public Object getUsersById(int id)
    {
        try {
            return new Data(this.repository.findById(id).get());
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public Object getAllUsers(){
        try {
            List<Utilisateur> user = new ArrayList<Utilisateur>();
            repository.findAll().forEach(user1 -> user.add(user1));
            return new Data(user);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public Object isValide(int idUser,String token){
        try {
            Data d=(Data) expiration.getExpirationById(token);
            Expiration exp =(Expiration) d.getData();
            if (exp.getDateexpiration().after(Token.getDateNow()))
                return new Data(true);
            return new Data(false);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void deconnexion(int idUser,String token){
        Expiration exp=new Expiration(token,Token.getDateNow());
        expiration.update(exp);
    }

    public void saveOrUpdate(Utilisateur users)
    {
        repository.save(users);
    }
    public void delete(int id)
    {
        repository.deleteById(id);
    }
    public void update(Utilisateur user, int userid)
    {
        repository.save(user);
    }

    public Object login(Utilisateur user){
        Object u=this.getAllUsers();
        if(u instanceof Error)
            return u;
        Data donnee=(Data) u;
        Object liste=donnee.getData();
        List<Utilisateur> users=(List<Utilisateur>) liste;
        for (int i = 0; i < users.size(); i++) {
            int log=0;
            if(users.get(i).getIdentifiant().compareTo(user.getIdentifiant())==0)
                log++;
            if(users.get(i).getPassword().compareTo(user.getPassword())==0)
                log++;
            if(log==2) {
                Token tkn=new Token(users.get(i).getIdUser());
                token.saveToken(tkn);
                return new Data(tkn);
            }
        }
        return new Data(false);
    }


}
