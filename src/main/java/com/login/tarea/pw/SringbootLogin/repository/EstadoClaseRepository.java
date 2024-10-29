package com.login.tarea.pw.SringbootLogin.repository;

import com.login.tarea.pw.SringbootLogin.model.EstadoClase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoClaseRepository extends JpaRepository<EstadoClase, Long> {
    @Query("SELECT e FROM EstadoClase e WHERE e.estado = :estado")
    EstadoClase findByName(String estado);
}