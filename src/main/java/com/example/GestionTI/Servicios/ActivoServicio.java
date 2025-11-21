package com.example.GestionTI.Servicios;

import com.example.GestionTI.Entidades.Activo;
import com.example.GestionTI.Entidades.Usuario;
import com.example.GestionTI.Request.ActivoRequest;
import com.example.GestionTI.Response.ActivosResponse;

import java.util.List;

public interface ActivoServicio {
    String registarActivo(ActivoRequest activoRequest);
    Activo findByActivo(Integer idActivo);
    List<Activo> todosActivos();
    ActivosResponse detallesActivo(Integer idActivo);
    List<Usuario> usuariosActivo(Integer id);
}
