package com.example.GestionTI.Servicios.Impl;

import com.example.GestionTI.Entidades.Area;
import com.example.GestionTI.Repositorio.AreaRepositorio;
import com.example.GestionTI.Servicios.AreaServicio;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class areaImplement implements AreaServicio {

    private final AreaRepositorio areaRepositorio;

    @Override
    public List<Area> todasAreas() {
        return areaRepositorio.findAll();
    }
}
