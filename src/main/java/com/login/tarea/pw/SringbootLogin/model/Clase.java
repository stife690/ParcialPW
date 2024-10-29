package com.login.tarea.pw.SringbootLogin.model;

import java.time.LocalTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Data;

@Entity
@Table(name = "clase")
@Data
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 30)
    @Size(max = 30)
    private String nombreAsignatura;
    
    
    @Column(length = 100)
    @Size(max = 100)
    private String descripcion;
    
    @NotNull
    private LocalTime horaInicio;

    @NotNull
    private LocalTime horaFinalizacion;
    
    
    @NotNull
    @Positive
    private Integer salon;

    @ManyToOne
    @JoinColumn(name = "estado", nullable = false)
    private EstadoClase estado;
    
    public Clase(Long id, @Size(max = 30) String nombreAsignatura, @Size(max = 30) String descripcion, 
            @NotNull LocalTime horaInicio, @NotNull LocalTime horaFinalizacion,  @NotNull @Positive Integer salon, EstadoClase estado) {
   this.id = id;
   this.nombreAsignatura = nombreAsignatura;
   this.descripcion = descripcion;
   this.horaInicio = horaInicio;
   this.horaFinalizacion = horaFinalizacion;
   this.salon = salon;
   this.estado = estado;
}

    public Clase(@Size(max = 30) String nombreAsignatura, @Size(max = 30) String descripcion,
    		@NotNull LocalTime horaInicio, @NotNull LocalTime horaFinalizacion, @NotNull @Positive Integer salon, EstadoClase estado) {
   this.nombreAsignatura = nombreAsignatura;
   this.descripcion = descripcion;
   this.horaInicio = horaInicio;
   this.horaFinalizacion = horaFinalizacion;
   this.salon = salon;
   this.estado = estado;
	}

	public Clase() {
		super();
	}	
}