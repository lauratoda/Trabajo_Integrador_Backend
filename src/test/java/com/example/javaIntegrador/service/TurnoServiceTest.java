package com.example.javaIntegrador.service;

import com.example.javaIntegrador.dto.OdontologoDTO;
import com.example.javaIntegrador.dto.PacienteDTO;
import com.example.javaIntegrador.dto.TurnoDTO;
import com.example.javaIntegrador.model.Domicilio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private ITurnoService turnoService;
    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IOdontologoService odontologoService;


    @Before
    @Transactional
    @DirtiesContext
    public void nuevoTurnoBefore() {
        LocalDateTime fechaHora = LocalDateTime.of(2023, 6, 19, 10, 30, 0);
        Domicilio domicilio = new Domicilio("Av Tejedor", "2223", "Mar del Plata", "Buenos Aires");
        OdontologoDTO o = new OdontologoDTO("Luis", "Alvarez", 32432);
        odontologoService.guardar(o);
        PacienteDTO p = new PacienteDTO("Delia", "Alvarez","776545", LocalDate.now(),domicilio);
        pacienteService.guardar(p);
        PacienteDTO pacienteDTO = pacienteService.buscar(1L);
        OdontologoDTO odontologoDTO = odontologoService.buscar(1L);
        assertNotNull(pacienteDTO);
        assertNotNull(odontologoDTO);

        TurnoDTO turnoDTO = new TurnoDTO(pacienteDTO,odontologoDTO,fechaHora);
        turnoService.guardar(turnoDTO);
    }

    @Test
    @Transactional
    @DirtiesContext
    public void guardarTurnoTest() {
    LocalDateTime fechaHora = LocalDateTime.of(2023, 6, 19, 10, 30, 0);
    Domicilio domicilio = new Domicilio("Av Tejedor", "2223", "Mar del Plata", "Buenos Aires");
    OdontologoDTO o = new OdontologoDTO("Luis", "Alvarez", 32432);
    odontologoService.guardar(o);
    PacienteDTO p = new PacienteDTO("Delia", "Alvarez","776545", LocalDate.now(),domicilio);
    pacienteService.guardar(p);

    PacienteDTO pacienteDTO = pacienteService.buscar(1L);
    OdontologoDTO odontologoDTO = odontologoService.buscar(1L);
    assertNotNull(pacienteDTO);
    assertNotNull(odontologoDTO);

    TurnoDTO turnoDTO = new TurnoDTO(pacienteDTO,odontologoDTO,fechaHora);
    turnoService.guardar(turnoDTO);
    TurnoDTO turnoDelia = turnoService.buscar(1L);
        assertNotNull(turnoDelia);

    }

    @Test
    public void buscarTurnoTest() {
        TurnoDTO turnoDTO = turnoService.buscar(1L);
        if (turnoDTO != null) {
            Assert.assertTrue(turnoDTO.getId().equals(1L));
        }
    }

    @Test
    public void traerTodos() {
        List<TurnoDTO> turnos = turnoService.buscarTodos();
        Assert.assertTrue(turnos.size() > 0);
    }

    @Test
    public void eliminarTest() {
        turnoService.eliminar(1L);
        Assert.assertNull(turnoService.buscar(1L));
    }

    @Test
    public void actualizarTest() {
        TurnoDTO turnoDTO = turnoService.buscar(1L);
        if (turnoDTO != null) {
            OdontologoDTO odontologoDTO = new OdontologoDTO("Pepe", "Corcho",465562);
            turnoDTO.setOdontologo(odontologoDTO);
            turnoService.actualizar(turnoDTO);
            Assert.assertTrue(turnoDTO.getOdontologo().equals(odontologoDTO));
        }
    }
}