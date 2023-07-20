package com.example.javaIntegrador.repository;


import com.example.javaIntegrador.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

//@Query ("SELECT * FROM Odontologos where o.nombre =?1")
//List<Odontologo> buscarPorNombre(String nombre);

}
