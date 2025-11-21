package com.example.GestionTI.Controladores;

import com.example.GestionTI.Entidades.Activo;
import com.example.GestionTI.Entidades.Usuario;
import com.example.GestionTI.Request.ActivoRequest;
import com.example.GestionTI.Response.ActivosResponse;
import com.example.GestionTI.Servicios.ActivoServicio;
import com.example.GestionTI.Servicios.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/activo")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class activoController {

    private final ActivoServicio activoServicio;
    private final UsuarioServicio usuarioServicio;

    @PostMapping("/registrar")
    public String registrarActivo(@RequestBody ActivoRequest activoRequest){
        return activoServicio.registarActivo(activoRequest);
    }

    @GetMapping("/{id}")
    public Activo buscarActivo(@PathVariable Integer id){
        return activoServicio.findByActivo(id);
    }

    @GetMapping("/todos")
    public List<Activo> totalActivo(){
        return activoServicio.todosActivos();
    }

    @GetMapping("/{id}/detalles")
    public ActivosResponse detallesActivo(@PathVariable Integer id){
        return activoServicio.detallesActivo(id);
    }

    @GetMapping("/{id}/activos")
    public List<Activo> usuarioActivos(@PathVariable Integer id){
        return usuarioServicio.activosUsuario(id);
    }

    @GetMapping("/{id}/usuarios")
    public List<Usuario> activoUsuarios(@PathVariable Integer id){
        return activoServicio.usuariosActivo(id);
    }

}
