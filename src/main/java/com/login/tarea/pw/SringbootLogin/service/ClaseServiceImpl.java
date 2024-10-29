package com.login.tarea.pw.SringbootLogin.service;

import com.login.tarea.pw.SringbootLogin.dto.ClaseDTO;
import com.login.tarea.pw.SringbootLogin.model.Clase;
import com.login.tarea.pw.SringbootLogin.model.EstadoClase;
import com.login.tarea.pw.SringbootLogin.repository.ClaseRepository;
import com.login.tarea.pw.SringbootLogin.repository.EstadoClaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private EstadoClaseRepository estadoRepositorio;

    @Override
    public Clase saveClase(ClaseDTO claseDTO) {

        EstadoClase estado = estadoRepositorio.findByName(claseDTO.getEstado());
        if (estado == null) {
            throw new IllegalArgumentException("Estado no encontrado");
        }

        Clase clase = new Clase(
                claseDTO.getNombreAsignatura(),
                claseDTO.getDescripcion(),
                claseDTO.getHoraInicio(),
                claseDTO.getHoraFinalizacion(),
                claseDTO.getSalon(),
                estado
            );
        
        
        try {
            Clase savedClase = claseRepository.save(clase);
            System.out.println("Clase guardada: " + savedClase);
            return savedClase;
        } catch (Exception e) {
            System.out.println("Error al guardar la clase: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Clase> getAllClases() {
        return claseRepository.findAll();
    }

    @Override
    public Clase getClaseById(Long id) {
        Optional<Clase> optionalClase = claseRepository.findById(id);
        return optionalClase.orElse(null);
    }

    @Override
    public Clase updateClase(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public void deleteClase(Clase clase) {
        claseRepository.delete(clase);
    }
}