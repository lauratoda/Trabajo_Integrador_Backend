package com.example.javaIntegrador.dto;

import lombok.Getter;
import lombok.Setter;
//import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OdontologoDTO implements Serializable {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    public OdontologoDTO(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
