package com.example.GestionTI.Repositorio;

import com.example.GestionTI.Entidades.Rol;
import com.example.GestionTI.Entidades.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepositorio extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByrolNombre(Roles rolNombre);
}
