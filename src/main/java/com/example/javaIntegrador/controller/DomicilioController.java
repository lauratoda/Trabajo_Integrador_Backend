package com.example.javaIntegrador.controller;

import com.example.javaIntegrador.model.Domicilio;
import com.example.javaIntegrador.service.DomicilioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/domicilio")

public class DomicilioController {

    private static final Logger logger = Logger.getLogger(DomicilioController.class);

    @Autowired
    private DomicilioService domicilioService;

    @PostMapping()
    public ResponseEntity<Domicilio> registrarDomicilio(@RequestBody Domicilio domicilio) {
        logger.info("Registrando domicilio...");
        return ResponseEntity.ok(domicilioService.guardar(domicilio));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Domicilio>> buscar(@PathVariable Long id) {
        logger.info("Buscando Domicilio por id: " + id + " en la base de datos...");

        Optional<Domicilio> domicilioOptional = domicilioService.buscar(id);

        if(domicilioOptional.isPresent()){
            Domicilio domicilio = domicilioOptional.get();
        } else {
            logger.error("Domicilio inexistente en la base de datos");
        }
        return ResponseEntity.ok(domicilioOptional);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Domicilio> actualizar(@RequestBody Domicilio domicilio) {
        logger.info("Actualizando domicilio en la base de datos...");
        ResponseEntity<Domicilio> response = null;

        if (domicilio.getId() != null && domicilioService.buscar(domicilio.getId()) != null) {
            logger.info("Domicilio actualizado con éxito");
            response = ResponseEntity.ok(domicilioService.actualizar(domicilio));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (domicilioService.buscar(id) != null) {
            domicilioService.eliminar(id);
            return ResponseEntity.ok().body("{\"message\": \"Eliminado\"}");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Domicilio>> buscarTodos(){
        logger.info("Buscando listado de todos los domicilios en la base de datos...");
        return ResponseEntity.ok(domicilioService.buscarTodos());
    }
}
