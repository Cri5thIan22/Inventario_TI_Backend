package com.example.GestionTI.Controladores;

import com.example.GestionTI.Entidades.Asignaciones;
import com.example.GestionTI.Request.AsignacionRequest;
import com.example.GestionTI.Servicios.AsignacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/asignacion")
@RequiredArgsConstructor
public class asignacionController {
    private final AsignacionServicio asignacionServicio;

    @PostMapping("/registrar")
    public String realizarAsignacion(@RequestBody AsignacionRequest asignacionRequest){
        return asignacionServicio.realizarAsignacion(asignacionRequest);
    }

    @GetMapping("/todas")
    public List<Asignaciones> registroAsignaciones(){
        return asignacionServicio.todasAsignaciones();
    }

}
