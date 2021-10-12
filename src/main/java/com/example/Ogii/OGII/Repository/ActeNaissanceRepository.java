package com.example.Ogii.OGII.Repository;

import com.example.Ogii.OGII.model.ActeNaissance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeNaissanceRepository extends JpaRepository <ActeNaissance, Integer> {

    boolean existsByFirstNameAndLastNameAndFirstNameMotherAndCommuneAndAddress(String firstname, String lastname, String firstNameMother, String commune ,String Address);
}
