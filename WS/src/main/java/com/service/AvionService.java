package com.service;

import com.models.Assurance;
import com.models.Avion;
import com.models.Data;
import com.models.Error;
import com.repository.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvionService {

    @Autowired
    AvionRepository repository;

    public Object getAllAvion(){
        try {
            List<Avion> KilometrageList = new ArrayList<Avion>();
            repository.findAll().forEach(KilometrageList1 -> KilometrageList.add(KilometrageList1));
            return new Data(KilometrageList);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public Object getAvion(int id){
        try {
            Avion av=repository.findById(id).get();
            return new Data(av);
        }
        catch (Exception e){
            return new Error(e);
        }
    }

    public void updateAvion(Avion avion)
    {
        repository.save(avion);
    }
}
