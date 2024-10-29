package com.login.tarea.pw.SringbootLogin.repository;

import com.login.tarea.pw.SringbootLogin.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {
    Clase findByNombre(String nombre);
}
