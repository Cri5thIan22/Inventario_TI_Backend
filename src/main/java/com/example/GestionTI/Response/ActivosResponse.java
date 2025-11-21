package com.example.GestionTI.Response;

import com.example.GestionTI.Entidades.TipoActivo;
import com.example.GestionTI.Request.DetalleCpu;
import com.example.GestionTI.Request.DetalleImpresora;
import com.example.GestionTI.Request.DetalleLaptop;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivosResponse {
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TipoActivo tipoActivo;
    private String marca;
    private String modelo;
    private EspecificacionDetalle especificacionDetalle;
}
    