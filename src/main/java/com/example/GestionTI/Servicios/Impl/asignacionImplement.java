package com.example.GestionTI.Servicios.Impl;

import com.example.GestionTI.Entidades.Activo;
import com.example.GestionTI.Entidades.Asignaciones;
import com.example.GestionTI.Entidades.Usuario;
import com.example.GestionTI.Repositorio.ActivoRepositorio;
import com.example.GestionTI.Repositorio.AsignacionRepositorio;
import com.example.GestionTI.Repositorio.UsuarioRepositorio;
import com.example.GestionTI.Request.AsignacionRequest;
import com.example.GestionTI.Servicios.AsignacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class asignacionImplement implements AsignacionServicio {
    private final AsignacionRepositorio asignacionRepositorio;
    private final ActivoRepositorio activoRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    @Override
    public String realizarAsignacion(AsignacionRequest asignacionRequest) {
        Set<Integer> usuariosId = asignacionRequest.getIdsUsuario();
        Set<Integer> activosId = asignacionRequest.getIdsActivos();

        List<Usuario> usuarioList = usuarioRepositorio.findAllById(usuariosId);
        List<Activo> activoList = activoRepositorio.findAllById(activosId);

        if (usuarioList.isEmpty() || activoList.isEmpty()){
            return "Lista de usuarios o activos vacia";
        }

        int asignacionesExitosas = 0;
        Date fechaActual = Date.valueOf(LocalDate.now());

        for (Usuario usuario:usuarioList){
            for (Activo activo:activoList){
                Asignaciones Nuevaasignacion = new Asignaciones();
                Nuevaasignacion.setUsuario(usuario);
                Nuevaasignacion.setActivo(activo);
                Nuevaasignacion.setFecha(fechaActual);
                asignacionRepositorio.save(Nuevaasignacion);
                asignacionesExitosas++;
            }
        }

        return String.format("Proceso completado. Se crearon %d asignaciones nuevas, reasignando todos los activos a todos los usuarios especificados.", asignacionesExitosas);
    }

    @Override
    public List<Asignaciones> todasAsignaciones() {
        return asignacionRepositorio.findAll();
    }

}
