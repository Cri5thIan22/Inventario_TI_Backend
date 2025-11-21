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
@Table(name = "specs_impresora")
public class specsImpresora {
    @Id
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "activo_id")
    private Activo activo;
    @Enumerated(EnumType.STRING)
    private EstadoActivo estadoActivo;
    private String conexion;
}
