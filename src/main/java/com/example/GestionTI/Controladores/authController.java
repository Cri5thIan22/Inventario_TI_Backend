package com.example.GestionTI.Controladores;

import com.example.GestionTI.Entidades.Usuario;
import com.example.GestionTI.Request.UsuarioRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.GestionTI.Servicios.UsuarioServicio;

@RequestMapping("api/v1/auth")
@RestController
@RequiredArgsConstructor
public class authController {

    private final UsuarioServicio usuarioServicio;

    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.ok(usuarioServicio.registrarUsuario(usuarioRequest));
    }

    @GetMapping("/usuario/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id){
        return usuarioServicio.buscarUsuarioId(id);
    }
}
