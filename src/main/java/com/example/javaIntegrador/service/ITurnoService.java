package com.example.javaIntegrador.service;

import com.example.javaIntegrador.dto.TurnoDTO;
import java.util.List;

public interface ITurnoService {
    void guardar (TurnoDTO turnoDTO);
    TurnoDTO buscar (Long id);
    void actualizar (TurnoDTO turnoDTO);
    void eliminar (Long id);
    List<TurnoDTO> buscarTodos();
}
