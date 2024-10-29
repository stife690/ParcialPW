package com.login.tarea.pw.SringbootLogin.service;

import com.login.tarea.pw.SringbootLogin.model.EstadoClase;
import com.login.tarea.pw.SringbootLogin.repository.EstadoClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoClaseServiceImpl implements EstadoClaseService {

    @Autowired
    private EstadoClaseRepository estadoRepositorio;

    @Override
    public List<EstadoClase> findAll() {
        return estadoRepositorio.findAll();
    }
}