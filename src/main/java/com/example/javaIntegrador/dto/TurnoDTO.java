package com.example.javaIntegrador.dto;

import com.example.javaIntegrador.model.Odontologo;
import com.example.javaIntegrador.model.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class TurnoDTO implements Serializable {
    private Long id;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;
    private LocalDateTime date;

    public TurnoDTO(PacienteDTO paciente, OdontologoDTO odontologo, LocalDateTime date) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }
}
