package com.service;

import com.models.Admin;
import com.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public boolean login(Admin admin){
        List<Admin> ad=adminRepository.findAll();
        for (int i = 0; i < ad.size(); i++) {
            if(ad.get(i).getNom().compareTo(admin.getNom())==0 && ad.get(i).getMdp().compareTo(admin.getMdp())==0){
                return true;
            }
        }
        return false;
    }
}
