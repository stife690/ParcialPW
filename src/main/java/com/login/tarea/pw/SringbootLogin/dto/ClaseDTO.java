package com.login.tarea.pw.SringbootLogin.dto;

import java.time.LocalTime;

import lombok.Data;

@Data
public class ClaseDTO {
    private String nombreAsignatura;
    private String descripcion;
    private LocalTime horaInicio;
    private LocalTime horaFinalizacion;
    private Integer salon;
    private String estado;
    
}