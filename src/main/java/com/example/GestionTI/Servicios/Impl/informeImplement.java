package com.example.GestionTI.Servicios.Impl;

import com.example.GestionTI.Entidades.Activo;
import com.example.GestionTI.Entidades.Informes;
import com.example.GestionTI.Entidades.Usuario;
import com.example.GestionTI.Repositorio.ActivoRepositorio;
import com.example.GestionTI.Repositorio.AsignacionRepositorio;
import com.example.GestionTI.Repositorio.InformesRepositorio;
import com.example.GestionTI.Repositorio.UsuarioRepositorio;
import com.example.GestionTI.Request.InformeRequest;
import com.example.GestionTI.Servicios.InformeServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class informeImplement implements InformeServicio {
    private final InformesRepositorio informesRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;
    private final ActivoRepositorio activoRepositorio;
    private final AsignacionRepositorio asignacionRepositorio;

    @Override
    public String crearInforme(InformeRequest informeRequest) {
        Usuario u = usuarioRepositorio.getReferenceById(informeRequest.getIdActivo());
        Activo a = activoRepositorio.getReferenceById(informeRequest.getIdActivo());

        Informes informe = new Informes();
        informe.setUsuario(u);
        informe.setActivo(a);
        informe.setMotivo(informeRequest.getMotivo());
        informe.setDescripcion(informeRequest.getDescripcion());
        informe.setFecha(Date.valueOf(LocalDate.now()));
        informesRepositorio.save(informe);

        return "Informe creado de manera exitosa";
    }

    @Override
    public List<Informes> todosInformes() {
        return informesRepositorio.findAll();
    }

    @Override
    public List<Informes> activoInformes(Integer id) {
        Optional<Activo> activo = activoRepositorio.findById(id);
        return informesRepositorio.findByActivoId(activo.get().getId());
    }

    @Override
    public List<Informes> usuarioInformes(Integer id) {
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        return informesRepositorio.findByUsuarioId(usuario.get().getId());
    }

}
