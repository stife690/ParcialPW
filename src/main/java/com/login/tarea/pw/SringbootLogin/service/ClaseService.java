package com.login.tarea.pw.SringbootLogin.service;

import com.login.tarea.pw.SringbootLogin.dto.ClaseDTO;
import com.login.tarea.pw.SringbootLogin.model.Clase;
import java.util.List;

public interface ClaseService {
    Clase saveClase(ClaseDTO claseDTO);
    List<Clase> getAllClases();
    Clase getClaseById(Long id);
    Clase updateClase(Clase clase);
    void deleteClase(Clase clase);
}
