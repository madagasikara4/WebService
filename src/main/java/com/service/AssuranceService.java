package com.service;

import com.models.Assurance;
import com.models.Data;
import com.repository.AssuranceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssuranceService {

    @Autowired
    AssuranceRepository repository;

    public Object getAllAssurance(){
        try {
            final List<Assurance> KilometrageList = new ArrayList<Assurance>();
            repository.findAll().forEach(KilometrageList1 -> KilometrageList.add(KilometrageList1));
            return new Data(KilometrageList);
        }
        catch (Exception e){
            return new Error(e);
        }
    }
}
