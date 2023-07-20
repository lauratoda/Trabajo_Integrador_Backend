package com.example.javaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name="Turnos")


public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="paciente_id", nullable = false) //, cascade = CascadeType.ALL
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Paciente paciente;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="odontologo_id", nullable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Odontologo odontologo;

    private LocalDateTime date;

    public Turno() {
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDateTime date) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", date=" + date +
                '}';
    }
}
