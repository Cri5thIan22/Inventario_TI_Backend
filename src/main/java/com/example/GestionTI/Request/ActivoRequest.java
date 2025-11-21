package com.example.GestionTI.Request;

import com.example.GestionTI.Entidades.TipoActivo;
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
public class ActivoRequest {
    @Enumerated(EnumType.STRING)
    private TipoActivo tipoActivo;
    private String marca;
    private String modelo;
    private DetalleCpu detalleCpu;
    private DetalleLaptop detalleLaptop;
    private DetalleImpresora detalleImpresora;
    private DetallePantalla detallePantalla;
    private DetalleTeclado detalleTeclado;
    private DetalleMouse detalleMouse;
}
