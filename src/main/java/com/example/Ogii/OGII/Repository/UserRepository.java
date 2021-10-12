package com.example.Ogii.OGII.Repository;

import com.example.Ogii.OGII.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmailAndPassword(String Email, String password);
}
