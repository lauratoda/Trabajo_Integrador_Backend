package com.example.javaIntegrador.service;

import com.example.javaIntegrador.dto.PacienteDTO;

import java.util.List;

public interface IPacienteService {

    void guardar (PacienteDTO pacienteDTO);
    PacienteDTO buscar (Long id);
    void actualizar (PacienteDTO pacienteDTO);
    void eliminar (Long id);
    List<PacienteDTO>buscarTodos();
}
