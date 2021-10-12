package com.example.Ogii.OGII.Repository;

import com.example.Ogii.OGII.model.Mairie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MairieRepository extends JpaRepository<Mairie,Integer> {

    boolean existsByAdresseAndCommuneAndNomAndPrenomAndNomPereAndNomMereAndProfessionMereAndProfessionPere(String commune, String adresse, String Nom, String Prenom,String NomPere, String NomMere,String ProfessionPere,String ProfessionMere);

    //boolean existsBy(int id);
}
