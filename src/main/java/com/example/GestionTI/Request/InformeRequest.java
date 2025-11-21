package com.example.GestionTI.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InformeRequest {
    private Integer idActivo;
    private Integer idUsuario;
    private String motivo;
    private String descripcion;
}
