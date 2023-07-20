package com.example.javaIntegrador.dto;

import com.example.javaIntegrador.model.Domicilio;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PacienteDTO implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;

    public PacienteDTO(String nombre, String apellido, String dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

}
