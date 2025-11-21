package com.example.GestionTI.Repositorio;

import com.example.GestionTI.Entidades.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepositorio extends JpaRepository<Area,Integer> {
    Optional<Area> findByareaNombre(String nombre);
}
