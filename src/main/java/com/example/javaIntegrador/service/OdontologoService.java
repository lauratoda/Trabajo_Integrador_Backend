package com.example.javaIntegrador.service;

import com.example.javaIntegrador.dto.OdontologoDTO;
import com.example.javaIntegrador.dto.PacienteDTO;
import com.example.javaIntegrador.model.Odontologo;
import com.example.javaIntegrador.model.Paciente;
import com.example.javaIntegrador.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    private IOdontologoRepository ORepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardar(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO buscar(Long id) {
        Optional<Odontologo> odontologo = ORepository.findById(id);
        OdontologoDTO odontologoDTO= null;
        if(odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }

    @Override
    public void actualizar(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminar(Long id) {
        ORepository.deleteById(id);
    }

    @Override
    public List<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologos = ORepository.findAll();
        List<OdontologoDTO> odontologosDTO = new ArrayList<>();

        for (Odontologo odontologo: odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }


//    public List<OdontologoDTO> buscarPorNombre(String nombre) {
//        List<Odontologo> odontologos = ORepository.buscarPorNombre(nombre);
//        List<OdontologoDTO> odontologosDTO = new ArrayList<>();
//
//        for (Odontologo odontologo: odontologos){
//            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
//        }
//        return odontologosDTO;
//    }

    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        ORepository.save(odontologo);
    }
}
