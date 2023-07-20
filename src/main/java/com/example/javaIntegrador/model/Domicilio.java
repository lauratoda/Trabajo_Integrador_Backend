package com.example.javaIntegrador.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name="Domicilios")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name= "id_paciente", referencedColumnName = "id")
    private Paciente paciente;

    public Domicilio() {
    }

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}