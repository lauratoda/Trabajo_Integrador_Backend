package com.example.javaIntegrador.service;

import com.example.javaIntegrador.dto.OdontologoDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private IOdontologoService odontologoService;

    @Before
    public void nuevoOdontologoBefore() {
        OdontologoDTO odontologoDTO = new OdontologoDTO("Pepe", "Milanesa", 455445);
        odontologoService.guardar(odontologoDTO);
    }

    @Test
    public void guardarOdontologoTest() {
        OdontologoDTO odontologoDTO = new OdontologoDTO("Juan","Perez", 56875);
        odontologoService.guardar(odontologoDTO);

        OdontologoDTO odontologoJuan = odontologoService.buscar(1L);
        assertTrue(odontologoJuan != null);

    }

    @Test
    public void buscarOdontologoTest() {
        OdontologoDTO odontologoDTO = odontologoService.buscar(1L);
        if (odontologoDTO != null) {
            Assert.assertTrue(odontologoDTO.getId().equals(1L));
        }
    }

    @Test
    public void listarTest() {
        List<OdontologoDTO> odontologos = odontologoService.buscarTodos();
        assertTrue(odontologos.size()>0);
    }

    @Test
    public void eliminarTest() {
        odontologoService.eliminar(1L);
        Assert.assertNull(odontologoService.buscar(1L));
    }

    @Test
    public void actualizarTest() {
        OdontologoDTO odontologoDTO = odontologoService.buscar(1L);
        if (odontologoDTO != null) {
            odontologoDTO.setApellido("NuevoApellido");
            odontologoService.actualizar(odontologoDTO);
            Assert.assertTrue(odontologoDTO.getApellido() != null && odontologoDTO.getApellido() == "NuevoApellido");
        }
    }

}
