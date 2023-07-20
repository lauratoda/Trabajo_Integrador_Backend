package com.example.javaIntegrador.controller;

import com.example.javaIntegrador.dto.OdontologoDTO;
import com.example.javaIntegrador.service.IOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    @Autowired
    private IOdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<?> registrarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        logger.info("Registrando Odontologo...");
        odontologoService.guardar(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscar(@PathVariable Long id) {
        logger.info("Buscando Odontolgo con id: " + id + " en la base de datos...");
        return odontologoService.buscar(id);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody OdontologoDTO odontologoDTO) {
        logger.info("Actualizando Odontologo en la base de datos...");
        odontologoService.actualizar(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        logger.info("Buscando Odontolgo con id: " + id + " y eliminandolo de la base de datos...");
        odontologoService.eliminar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<OdontologoDTO>> buscarTodos(){
        logger.info("Buscando listado de todos los Odontologos en la base de datos...");
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

//    @GetMapping("/{nombre}")
//    public ResponseEntity<List<OdontologoDTO>> buscarPorNombre(@PathVariable String nombre) {
//        logger.info("Buscando Odontólogos que coincidan con el nombre: " + nombre + ", buscado en la base datos...");
//        List<OdontologoDTO> coincidencias = odontologoService.buscarPorNombre(nombre);
//        if (!coincidencias.isEmpty()) {
//            logger.info("Se han encontrado coincidencias en la base datos...");
//            return ResponseEntity.ok(coincidencias);
//        } else {
//            logger.info("No se han encontrado coincidencias en la base datos...");
//            return ResponseEntity.notFound().build();
//        }
//    }
}

