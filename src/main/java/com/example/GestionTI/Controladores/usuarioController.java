package com.example.GestionTI.Controladores;

import com.example.GestionTI.Entidades.Usuario;
import com.example.GestionTI.Servicios.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/usuarios")
@CrossOrigin(origins = "http://localhost:5173")
public class usuarioController {
    private final UsuarioServicio usuarioServicio;

    @GetMapping("/todos")
    public List<Usuario> todosUsuarios(){
        return usuarioServicio.todosUsuarios();
    }

    @GetMapping("/area/{id}")
    public List<Usuario> usuariosArea(@PathVariable Integer id){
        return usuarioServicio.usuariosArea(id);
    }

}
