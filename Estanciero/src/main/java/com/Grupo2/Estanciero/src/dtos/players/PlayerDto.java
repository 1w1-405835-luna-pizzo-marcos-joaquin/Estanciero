package com.Grupo2.Estanciero.src.dtos.players;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayerDto {

    private int idJugador;
    private String nombre;
    private int dinero;
    private int casillaActual;
    private String tipo;
}
