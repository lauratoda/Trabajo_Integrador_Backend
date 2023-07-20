package com.example.javaIntegrador.controller;

import com.example.javaIntegrador.dto.PacienteDTO;
import com.example.javaIntegrador.service.IPacienteService;
import com.example.javaIntegrador.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<?> registrarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        logger.info("Registrando Paciente...");
        pacienteService.guardar(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscar(@PathVariable Long id) {
        logger.info("Buscando Paciente con id: " + id + " en la base de datos...");
        return pacienteService.buscar(id);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody PacienteDTO pacienteDTO) {
        logger.info("Actualizando Paciente en la base de datos...");
        pacienteService.actualizar(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        logger.info("Buscando Paciente con id: " + id + " y eliminandolo de la base de datos...");
        pacienteService.eliminar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<PacienteDTO>> buscarTodos(){
        logger.info("Buscando listado de todos los Pacientes en la base de datos...");
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
}
