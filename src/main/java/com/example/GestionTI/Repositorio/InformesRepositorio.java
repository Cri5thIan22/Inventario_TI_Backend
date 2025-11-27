package com.example.GestionTI.Repositorio;

import com.example.GestionTI.Entidades.Asignaciones;
import com.example.GestionTI.Entidades.Informes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InformesRepositorio extends JpaRepository<Informes, Integer> {
    List<Informes> findByUsuarioId(Integer usuarioId);
    List<Informes> findByActivoId(Integer activoId);
}
