package com.example.GestionTI.Repositorio;

import com.example.GestionTI.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findByAreaId(Integer id);
}
