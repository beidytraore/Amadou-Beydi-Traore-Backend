package com.example.Ogii.OGII.service;

import com.example.Ogii.OGII.Repository.ActeNaissanceRepository;
import com.example.Ogii.OGII.model.ActeNaissance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActeNaissanceService {
    @Autowired
    ActeNaissanceRepository acteNaissanceRepository;

    public List<ActeNaissance> getallActeNaissance() {
        try {
            List<ActeNaissance> acteNaissances = acteNaissanceRepository.findAll();
            List<ActeNaissance> customacteNaissances = new ArrayList<>();
            acteNaissances.stream().forEach(e -> {
                ActeNaissance acteNaissance = new ActeNaissance();
                BeanUtils.copyProperties(e, acteNaissance);
                customacteNaissances.add(acteNaissance);
            });
            return customacteNaissances;
        } catch (Exception e) {
            throw e;
        }
    }
    public String AjouterActeNaissance(ActeNaissance acteNaissance) {
        try {
            if(!acteNaissanceRepository.existsByFirstNameAndLastNameAndFirstNameMotherAndCommuneAndAddress(acteNaissance.getFirstName(), acteNaissance.getLastName(), acteNaissance.getFirstNameMother(), acteNaissance.getCommune(), acteNaissance.getAddress())){
                acteNaissanceRepository.save(acteNaissance);
                return "User added Succesfully";
            }else {
                return "This login is already exists in the database";
            }
        }catch (Exception e) {
            throw e;
        }
    }


    public String updateacteNaissance(ActeNaissance acteNaissance) {
        try {
            if (acteNaissanceRepository.existsById(acteNaissance.getId())) {
                acteNaissanceRepository.save(acteNaissance);
                return "User updated successfully";
            }else {
                return "User does not exist";
            }
        }catch (Exception e) {
            throw e;
        }

    }


    //public  deleteActeNaissance(ActeNaissance acteNaissance) {
     //   try {
     //       if (!acteNaissanceRepository.existsByFirstNameAndLastNameAndFirstNameMotherAndCommuneAndAddress(acteNaissance.getFirstName(), acteNaissance.getLastName(), acteNaissance.getFirstNameMother(), acteNaissance.getCommune(), acteNaissance.getAddress())) {
      //          acteNaissanceRepository.delete(acteNaissance);
       //         return "User deleted succesfully";
        //    }else {
          //      return "User does not exists";
       //     }
        //}catch (Exception e) {
       //     throw e;
      //  }
    //}
    }
