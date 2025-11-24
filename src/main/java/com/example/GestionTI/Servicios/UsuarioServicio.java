package com.example.GestionTI.Servicios;

import com.example.GestionTI.Entidades.Activo;
import com.example.GestionTI.Entidades.Usuario;
import com.example.GestionTI.Request.LogRequest;
import com.example.GestionTI.Request.UsuarioRequest;

import java.util.List;

public interface UsuarioServicio {
    String registrarUsuario(UsuarioRequest usuarioRequest);
    Usuario buscarUsuarioId(Integer id);
    List<Usuario> todosUsuarios();
    List<Activo> activosUsuario(Integer id);
    List<Usuario> usuariosArea(Integer id);
    String loginUsuario(LogRequest logRequest);
}
