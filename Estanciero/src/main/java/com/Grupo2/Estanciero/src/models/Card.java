package com.Grupo2.Estanciero.src.models;

import jakarta.annotation.security.DenyAll;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private Long id;

    private String descripcion;

    private String tipo;

    private String accion;

    private int valor;

}
