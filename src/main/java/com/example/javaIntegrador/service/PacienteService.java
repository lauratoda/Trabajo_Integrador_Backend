package com.example.javaIntegrador.service;

import com.example.javaIntegrador.dto.PacienteDTO;
import com.example.javaIntegrador.model.Paciente;
import com.example.javaIntegrador.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService  {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardar(PacienteDTO pacienteDTO) {
        pacienteDTO.setFechaIngreso(LocalDate.now());
        guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO buscar(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO= null;
        if(paciente.isPresent())
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

    @Override
    public void actualizar(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<PacienteDTO> buscarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDTO> pacientesDTO = new ArrayList<>();

        for (Paciente paciente: pacientes){
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacientesDTO;
    }

    private void guardarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);
    }

}
