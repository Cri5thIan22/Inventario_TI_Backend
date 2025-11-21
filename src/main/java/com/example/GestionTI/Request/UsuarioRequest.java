package com.example.GestionTI.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    private String nombres;
    private String apellidos;
    private String email;
    private String contraseña;
    private String area;
}
