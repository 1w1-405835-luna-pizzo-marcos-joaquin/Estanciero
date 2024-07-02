package com.Grupo2.Estanciero.src.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Propiedades {

    private int idPropiedad;
    private int idPropietrio;
    private int nroCasilla;
    private int precio;
    private int precioMejora;
    private int cantidadChacras;
    private int alquiler;
    private int precioVenta;
    private String provincia;
    private String zona;


}
