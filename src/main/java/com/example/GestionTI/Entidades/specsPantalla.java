package com.example.GestionTI.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "specs_Pantalla")
public class specsPantalla {
    @Id
    private Integer id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "activo_id")
    private Activo activo;
    @Enumerated(EnumType.STRING)
    private EstadoActivo estadoActivo;
    private String pulgadas;
    private String resolucion;
}
