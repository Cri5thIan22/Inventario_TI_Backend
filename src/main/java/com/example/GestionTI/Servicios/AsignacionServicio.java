package com.example.GestionTI.Servicios;

import com.example.GestionTI.Entidades.Asignaciones;
import com.example.GestionTI.Request.AsignacionRequest;

import java.util.List;

public interface AsignacionServicio {
    String realizarAsignacion(AsignacionRequest asignacionRequest);
    List<Asignaciones> todasAsignaciones();
}
