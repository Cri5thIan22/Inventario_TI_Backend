package com.example.GestionTI.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "specs_Mouse")
public class specsMouse {
    @Id
    private Integer id;
    @OneToOne
    @MapsId
    @JoinColumn(name = "activo_id")
    private Activo activo;
    private String conexion;
}
