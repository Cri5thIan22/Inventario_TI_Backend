package com.example.GestionTI.Response;

import com.example.GestionTI.Request.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EspecificacionDetalle {
    private DetalleCpu detalleCpu;
    private DetalleLaptop detalleLaptop;
    private DetallePantalla detallePantalla;
    private DetalleImpresora detalleImpresora;
    private DetalleTeclado detalleTeclado;
    private DetalleMouse detalleMouse;
}
