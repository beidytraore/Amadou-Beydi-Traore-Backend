package com.example.Ogii.OGII.service;


import com.example.Ogii.OGII.Repository.MairieRepository;
import com.example.Ogii.OGII.model.Mairie;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MairieService {
    @Autowired
    MairieRepository mairieRepository;

    public List<Mairie> getAllMairie() {
        try {
         List<Mairie> mairies = mairieRepository.findAll();
         List<Mairie> customMairies = new ArrayList<>();
         mairies.stream().forEach(e -> {
         Mairie mairie = new Mairie();
            BeanUtils.copyProperties(e,mairie);
            customMairies.add(mairie);
         });
         return customMairies;
        }catch (Exception e) {
            throw e;
        }
    }

    public String addMairie(Mairie mairie) {
        try {
         if(!mairieRepository.existsByAdresseAndCommuneAndNomAndPrenomAndNomPereAndNomMereAndProfessionMereAndProfessionPere(mairie.getAdresse(),mairie.getCommune(),mairie.getPrenom(),mairie.getNom(),mairie.getPrenomPere(),mairie.getPrenomMere(),mairie.getProfessionPere(),mairie.getProfessionMere())){
             mairieRepository.save(mairie);
             return "Mairie added Succesfully";
         }else {
             return "This mairie is already exists in the database";
         }
        }catch (Exception e) {
            throw e;
        }
    }

}
