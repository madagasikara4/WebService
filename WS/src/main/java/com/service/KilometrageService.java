package com.service;

import com.models.Data;
import com.models.Error;
import com.models.Kilometrage;
import com.repository.KilometrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KilometrageService {

    @Autowired
    KilometrageRepository repository;

    public Object getAllKilometrageByAvion(int idavion){
        try {
            List<Kilometrage> KilometrageList = new ArrayList<Kilometrage>();
            repository.findAll().forEach(KilometrageList1 -> KilometrageList.add(KilometrageList1));
            for (int i = 0; i < KilometrageList.size(); i++) {
                if(KilometrageList.get(i).getIdavion()==idavion)
                    continue;
                KilometrageList.remove(i);
                i--;
            }
            return new Data(KilometrageList);
        }
        catch (Exception e){
            return new Error(e);
        }
    }
}
