package com.example.GestionTI.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignacionRequest {
    private Set<Integer> idsUsuario;
    private Set<Integer> idsActivos;
}
