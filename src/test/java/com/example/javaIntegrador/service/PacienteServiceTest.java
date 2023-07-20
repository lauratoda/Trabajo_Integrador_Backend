package com.example.javaIntegrador.service;

import com.example.javaIntegrador.dto.OdontologoDTO;
import com.example.javaIntegrador.dto.PacienteDTO;
import com.example.javaIntegrador.model.Domicilio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private IPacienteService pacienteService;

    @Before
    public void nuevoPacienteBefore() {
        Domicilio domicilio = new Domicilio("Av Tejedor", "2223", "Mar del Plata", "Buenos Aires");
        PacienteDTO pacienteDTO = new PacienteDTO("Pepe","Milanesa","62566262", LocalDate.now(),domicilio);
        pacienteService.guardar(pacienteDTO);
    }

    @Test
    public void guardarPacienteTest() {
        Domicilio domicilio = new Domicilio("Av Tejedor", "2223", "Mar del Plata", "Buenos Aires");
        PacienteDTO pacienteDTO = new PacienteDTO("Pepe","Milanesa","62566262", LocalDate.now(),domicilio);
        pacienteService.guardar(pacienteDTO);

        PacienteDTO pacienteJuan = pacienteService.buscar(1L);
        assertTrue(pacienteJuan != null);

    }

    @Test
    public void buscarPacienteTest() {
        PacienteDTO pacienteDTO = pacienteService.buscar(1L);
        if (pacienteDTO != null) {
            Assert.assertTrue(pacienteDTO.getId().equals(1L));
        }
    }

    @Test
    public void listarTest() {
        List<PacienteDTO> pacientes = pacienteService.buscarTodos();
        assertTrue(pacientes.size()>0);
    }

    @Test
    public void eliminarTest() {
        pacienteService.eliminar(1L);
        Assert.assertNull(pacienteService.buscar(1L));
    }

    @Test
    public void actualizarTest() {
        PacienteDTO pacienteDTO = pacienteService.buscar(1L);
        if (pacienteDTO != null) {
            pacienteDTO.setApellido("NuevoApellido");
            pacienteService.actualizar(pacienteDTO);
            Assert.assertTrue(pacienteDTO.getApellido() != null && pacienteDTO.getApellido() == "NuevoApellido");
        }
    }

}