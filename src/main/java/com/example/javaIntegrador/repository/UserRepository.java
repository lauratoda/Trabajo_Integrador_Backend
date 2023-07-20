package com.example.javaIntegrador.repository;

import com.example.javaIntegrador.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

//    public UserRepository findByUsername(String username);

        Optional<AppUser> findByEmail(String email);


}