package com.example.javaIntegrador.service;

import com.example.javaIntegrador.dto.OdontologoDTO;
import java.util.List;

public interface IOdontologoService {
    void guardar (OdontologoDTO odontologoDTO);
    OdontologoDTO buscar (Long id);
    void actualizar (OdontologoDTO odontologoDTO);
    void eliminar (Long id);
    List<OdontologoDTO> buscarTodos();
}
