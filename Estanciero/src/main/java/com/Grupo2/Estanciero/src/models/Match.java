package com.Grupo2.Estanciero.src.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
public class Match {

    private Long id;
    private ArrayList<Jugador> players;
    private ArrayList<Propiedades> propiedades;
    private Dificultad dificultad;
    private MatchStatus matchStatus;
    private int modo;
    private int montoGanador;
    private LocalDateTime createAt;
    private LocalDateTime updatet;

}
