package com.Grupo2.Estanciero.src.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Casilla {

    private int num_casilla;
    private int tipo;
    private Propiedades propiedad;

}

