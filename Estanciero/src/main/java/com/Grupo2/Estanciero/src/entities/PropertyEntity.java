package com.Grupo2.Estanciero.src.entities;

import com.Grupo2.Estanciero.src.entities.players.PlayerEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "properties")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "propietario")
    private int idPropietario;

    @Column(name = "casilla")
    private int nroCasilla;

    @Column
    private int precio;

    @Column(name = "chacras")
    private int cantidadChacras;

    @Column
    private int alquiler;

    @Column
    private String provincia;

    @Column
    private String zona;

    @Column(name = "mejora")
    private int precioMejora;

    @Column(name = "venta")
    private int precioVenta;
}
