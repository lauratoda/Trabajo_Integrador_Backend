package com.example.javaIntegrador.controller;

import com.example.javaIntegrador.dto.PacienteDTO;
import com.example.javaIntegrador.dto.TurnoDTO;
import com.example.javaIntegrador.model.Turno;
import com.example.javaIntegrador.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private static final Logger logger = Logger.getLogger(TurnoController.class);

    @Autowired
    private ITurnoService turnoService;
    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IOdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<?> registrarTurno(@RequestBody TurnoDTO turnoDTO) {
        logger.info("Registrando Turno...");
        turnoService.guardar(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDTO buscar(@PathVariable Long id) {
        logger.info("Buscando Turno con id: " + id + " en la base de datos...");
        return turnoService.buscar(id);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody TurnoDTO turnoDTO) {
        logger.info("Actualizando Turno en la base de datos...");
        turnoService.actualizar(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        logger.info("Buscando Turno con id: " + id + " y eliminandolo de la base de datos...");
        turnoService.eliminar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TurnoDTO>> buscarTodos(){
        logger.info("Buscando listado de todos los Turnos en la base de datos...");
        return ResponseEntity.ok(turnoService.buscarTodos());
    }
}
