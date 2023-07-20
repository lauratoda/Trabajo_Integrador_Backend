package com.example.javaIntegrador.service;

import com.example.javaIntegrador.dto.TurnoDTO;
import com.example.javaIntegrador.model.Turno;
import com.example.javaIntegrador.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardar(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO buscar(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO= null;
        if(turno.isPresent())
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public void actualizar(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public void eliminar(Long id) {
    turnoRepository.deleteById(id);
    }

    @Override
    public List<TurnoDTO> buscarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        List<TurnoDTO> turnosDTO = new ArrayList<>();

        for (Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnosDTO;
    }

    private void guardarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }
}