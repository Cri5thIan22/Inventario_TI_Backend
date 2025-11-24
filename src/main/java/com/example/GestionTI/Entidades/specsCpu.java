package com.example.GestionTI.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "specs_Cpu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class specsCpu {
    @Id
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_activo")
    private Activo activo;
    @Enumerated(EnumType.STRING)
    private EstadoActivo estado;
    private String sistema;
    private String procesador;
    private String almacenamiento;
    private String ram;
    private String edadEquipo;
}
