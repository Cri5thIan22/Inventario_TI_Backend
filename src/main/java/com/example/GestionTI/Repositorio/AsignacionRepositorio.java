package com.example.GestionTI.Repositorio;

import com.example.GestionTI.Entidades.Asignaciones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignacionRepositorio extends JpaRepository<Asignaciones,Integer> {
    List<Asignaciones> findByUsuarioId(Integer id);
    List<Asignaciones> findByActivoId(Integer id);
}
