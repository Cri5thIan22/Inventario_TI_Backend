package com.example.GestionTI.Request;

import com.example.GestionTI.Entidades.EstadoActivo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DetallePantalla {
    @Enumerated(EnumType.STRING)
    private EstadoActivo estadoActivo;
    private String pulgadas;
    private String resolucion;
}
