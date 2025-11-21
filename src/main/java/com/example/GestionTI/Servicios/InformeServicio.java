package com.example.GestionTI.Servicios;

import com.example.GestionTI.Entidades.Informes;
import com.example.GestionTI.Request.InformeRequest;

import java.util.List;

public interface InformeServicio {
    String crearInforme(InformeRequest informeRequest);
    List<Informes> todosInformes();
    List<Informes> activoInformes(Integer id);
    List<Informes> usuarioInformes(Integer id);
}
