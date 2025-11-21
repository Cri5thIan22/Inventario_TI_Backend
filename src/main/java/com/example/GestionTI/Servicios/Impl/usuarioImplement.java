package com.example.GestionTI.Servicios.Impl;

import com.example.GestionTI.Entidades.*;
import com.example.GestionTI.Repositorio.*;
import com.example.GestionTI.Servicios.UsuarioServicio;
import com.example.GestionTI.Request.UsuarioRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class usuarioImplement implements UsuarioServicio {

    private final UsuarioRepositorio usuarioRepositorio;
    private final RolRepositorio rolRepositorio;
    private final AreaRepositorio areaRepositorio;
    private final AsignacionRepositorio asignacionRepositorio;
    private final ActivoRepositorio activoRepositorio;

    @Override
    public String registrarUsuario(UsuarioRequest usuarioRequest) {
        Usuario nuevoUsuario = getEntityUsuario(usuarioRequest);

        if (usuarioRepositorio.findByEmail(nuevoUsuario.getEmail()).isPresent()){
            return "El email ingresado ya esta registrado con otro usuario";
        }

        String area = usuarioRequest.getArea();
        String nombreArea = area.trim().toUpperCase();

        Rol rolDefecto = rolRepositorio.findByrolNombre(Roles.USER).orElseThrow(()->new RuntimeException("Rol no encontrado en la BD"));
        List<Rol> rolSet = new ArrayList<>();
        rolSet.add(rolDefecto);

        Area a = areaRepositorio.findByareaNombre(nombreArea).orElseGet(
                ()->{
                    Area nuevaArea = new Area();
                    nuevaArea.setAreaNombre(nombreArea);
                    return areaRepositorio.save(nuevaArea);
                }
        );

        nuevoUsuario.setRoles(rolSet);
        nuevoUsuario.setArea(a);
        usuarioRepositorio.save(nuevoUsuario);
        return "Usuario creado con exito";
    }

    @Override
    public Usuario buscarUsuarioId(Integer id) {
        return usuarioRepositorio.findById(id).orElseThrow(()->new RuntimeException("No existe usuario con ese ID"));
    }

    @Override
    public List<Usuario> todosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public List<Activo> activosUsuario(Integer id) {
        List<Asignaciones> asignacionesUsuario = asignacionRepositorio.findByUsuarioId(id);
        List<Activo> activosUsuario = new ArrayList<>();

        if (asignacionesUsuario.isEmpty()){
            return Collections.emptyList();
        }

        for (Asignaciones asignacion:asignacionesUsuario){
            Integer idActivo = asignacion.getActivo().getId();
            Activo a1 = activoRepositorio.findById(idActivo).orElseThrow(() -> new EntityNotFoundException("Activo con ID " +idActivo + " no encontrado"));
            activosUsuario.add(a1);
        }
        return activosUsuario;
    }

    @Override
    public List<Usuario> usuariosArea(Integer id) {
        Area area = areaRepositorio.findById(id).orElseThrow(() -> new EntityNotFoundException("No existe area creada con ese " +id));
        return usuarioRepositorio.findByAreaId(area.getId());
    }

    public Usuario getEntityUsuario(UsuarioRequest usuarioRequest){
        Usuario getEntity = new Usuario();
        getEntity.setNombres(usuarioRequest.getNombres());
        getEntity.setApellidos(usuarioRequest.getApellidos());
        getEntity.setEmail(usuarioRequest.getEmail());
        getEntity.setContraseña(usuarioRequest.getContraseña());
        return getEntity;
    }
}
