package com.example.GestionTI.Servicios.Impl;

import com.example.GestionTI.Entidades.*;
import com.example.GestionTI.Repositorio.*;
import com.example.GestionTI.Request.*;
import com.example.GestionTI.Response.ActivosResponse;
import com.example.GestionTI.Response.EspecificacionDetalle;
import com.example.GestionTI.Servicios.ActivoServicio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class activoImplement implements ActivoServicio {
    private final ActivoRepositorio activoRepositorio;
    private final CpuRepositorio cpuRepositorio;
    private final LaptopRepositorio laptopRepositorio;
    private final ImpresoraRepositorio impresoraRepositorio;
    private final PantallaRepositorio pantallaRepositorio;
    private final TecladoRepositorio tecladoRepositorio;
    private final MouseRepositorio mouseRepositorio;
    private final AsignacionRepositorio asignacionRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    @Override
    public String registarActivo(ActivoRequest activoRequest) {
        Activo a1 = new Activo();
        TipoActivo tipo = activoRequest.getTipoActivo();
        a1.setTipo(tipo);
        a1.setMarca(activoRequest.getMarca());
        a1.setModelo(activoRequest.getModelo());
        Activo activoGuardar = activoRepositorio.save(a1);

        switch (tipo){
            case CPU :
                specsCpu detalleCpu = new specsCpu();
                detalleCpu.setActivo(activoGuardar);
                detalleCpu.setSistema(activoRequest.getDetalleCpu().getSistema());
                detalleCpu.setEstado(activoRequest.getDetalleCpu().getEstadoActivo());
                detalleCpu.setProcesador(activoRequest.getDetalleCpu().getProcesador());
                detalleCpu.setAlmacenamiento(activoRequest.getDetalleCpu().getAlmacenamiento());
                detalleCpu.setRam(activoRequest.getDetalleCpu().getRam());
                detalleCpu.setEdadEquipo(activoRequest.getDetalleCpu().getEdadEquipo());
                cpuRepositorio.save(detalleCpu);
                break;
            case LAPTOP:
                specsLaptop detalleLaptop = new specsLaptop();
                detalleLaptop.setActivo(activoGuardar);
                detalleLaptop.setEstado(activoRequest.getDetalleLaptop().getEstadoActivo());
                detalleLaptop.setSistema(activoRequest.getDetalleLaptop().getSistema());
                detalleLaptop.setProcesador(activoRequest.getDetalleLaptop().getProcesador());
                detalleLaptop.setAlmacenamiento(activoRequest.getDetalleLaptop().getAlmacenamiento());
                detalleLaptop.setRam(activoRequest.getDetalleLaptop().getRam());
                detalleLaptop.setSerie(activoRequest.getDetalleLaptop().getSerie());
                detalleLaptop.setEdadEquipo(activoRequest.getDetalleLaptop().getEdadEquipo());
                laptopRepositorio.save(detalleLaptop);
                break;
            case PANTALLA:
                specsPantalla detallePantalla = new specsPantalla();
                detallePantalla.setActivo(activoGuardar);
                detallePantalla.setEstadoActivo(activoRequest.getDetallePantalla().getEstadoActivo());
                detallePantalla.setPulgadas(activoRequest.getDetallePantalla().getPulgadas());
                detallePantalla.setResolucion(activoRequest.getDetallePantalla().getResolucion());
                pantallaRepositorio.save(detallePantalla);
                break;
            case IMPRESORA:
                specsImpresora detalleImpresora = new specsImpresora();
                detalleImpresora.setActivo(activoGuardar);
                detalleImpresora.setEstadoActivo(activoRequest.getDetalleImpresora().getEstadoActivo());
                detalleImpresora.setConexion(activoRequest.getDetalleImpresora().getConexion());
                impresoraRepositorio.save(detalleImpresora);
                break;
            case TECLADO:
                specsTeclado detalleTeclado = new specsTeclado();
                detalleTeclado.setActivo(activoGuardar);
                detalleTeclado.setConexion(activoRequest.getDetalleTeclado().getConexion());
                tecladoRepositorio.save(detalleTeclado);
                break;
            case MOUSE:
                specsMouse detalleMouse = new specsMouse();
                detalleMouse.setActivo(activoGuardar);
                detalleMouse.setConexion(activoRequest.getDetalleMouse().getConexion());
                mouseRepositorio.save(detalleMouse);
                break;
        }
        return "Activo con el ID: " +activoGuardar.getId() +" creado con exito";
    }

    @Override
    public Activo findByActivo(Integer idActivo) {
        return activoRepositorio.findById(idActivo).orElseThrow(()-> new RuntimeException("No existe el activo"));
    }

    @Override
    public List<Activo> todosActivos() {
        return activoRepositorio.findAll();
    }

    @Override
    public ActivosResponse detallesActivo(Integer idActivo) {
        Activo activo = activoRepositorio.findById(idActivo).orElse(null);
        TipoActivo tipoActivo = activo.getTipo();

        ActivosResponse activosResponse = getResponseActivos(activo);

        EspecificacionDetalle especificacionDetalle = new EspecificacionDetalle();
        switch (tipoActivo){
            case CPU :
                specsCpu specsCpu = cpuRepositorio.findById(idActivo).orElse(null);
                DetalleCpu detalleCpu = new DetalleCpu(
                        specsCpu.getEstado(),
                        specsCpu.getSistema(),
                        specsCpu.getProcesador(),
                        specsCpu.getAlmacenamiento(),
                        specsCpu.getRam(),
                        specsCpu.getEdadEquipo());
                especificacionDetalle.setDetalleCpu(detalleCpu);
                break;
            case LAPTOP:
                specsLaptop specsLaptop = laptopRepositorio.findById(idActivo).orElse(null);
                DetalleLaptop detalleLaptop = new DetalleLaptop(
                        specsLaptop.getEstado(),
                        specsLaptop.getProcesador(),
                        specsLaptop.getSistema(),
                        specsLaptop.getAlmacenamiento(),
                        specsLaptop.getRam(),
                        specsLaptop.getSerie(),
                        specsLaptop.getEdadEquipo()
                );
                especificacionDetalle.setDetalleLaptop(detalleLaptop);
                break;
            case IMPRESORA:
                specsImpresora specsImpresora = impresoraRepositorio.findById(idActivo).orElse(null);
                DetalleImpresora detalleImpresora = new DetalleImpresora(
                        specsImpresora.getEstadoActivo(),
                        specsImpresora.getConexion()
                );
                especificacionDetalle.setDetalleImpresora(detalleImpresora);
                break;
            case PANTALLA:
                specsPantalla specsPantalla = pantallaRepositorio.findById(idActivo).orElse(null);
                DetallePantalla detallePantalla = new DetallePantalla(
                        specsPantalla.getEstadoActivo(),
                        specsPantalla.getPulgadas(),
                        specsPantalla.getResolucion()
                );
                especificacionDetalle.setDetallePantalla(detallePantalla);
                break;
            case TECLADO:
                specsTeclado specsTeclado = tecladoRepositorio.findById(idActivo).orElse(null);
                DetalleTeclado detalleTeclado = new DetalleTeclado(
                        specsTeclado.getConexion()
                );
                especificacionDetalle.setDetalleTeclado(detalleTeclado);
                break;
            case MOUSE:
                specsMouse specsMouse = mouseRepositorio.findById(idActivo).orElse(null);
                DetalleMouse detalleMouse = new DetalleMouse(
                        specsMouse.getConexion()
                );
                especificacionDetalle.setDetalleMouse(detalleMouse);
                break;
        }

        activosResponse.setEspecificacionDetalle(especificacionDetalle);
        return activosResponse;
    }

    @Override
    public List<Usuario> usuariosActivo(Integer id) {
        List<Asignaciones> asignaciones = asignacionRepositorio.findByActivoId(id);
        List<Usuario> usuarios = new ArrayList<>();

        if (asignaciones.isEmpty()){
            return Collections.emptyList();
        }

        for (Asignaciones asignacion:asignaciones){
            Integer idUsuario = asignacion.getUsuario().getId();
            Usuario u1 = usuarioRepositorio.findById(idUsuario).orElseThrow(() -> new EntityNotFoundException("Activo con ID " +idUsuario + " no encontrado"));;
            usuarios.add(u1);
        }
        return usuarios;
    }

    public ActivosResponse getResponseActivos(Activo activo){
        ActivosResponse activosResponse = new ActivosResponse();
        activosResponse.setId(activo.getId());
        activosResponse.setTipoActivo(activo.getTipo());
        activosResponse.setMarca(activo.getMarca());
        activosResponse.setModelo(activo.getModelo());
        return activosResponse;
    }

}
