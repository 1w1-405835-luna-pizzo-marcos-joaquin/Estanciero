package com.Grupo2.Estanciero.src.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PropertyDto {

    private int idPropiedad;
    private int idPropietrio;
    private int precio;
    private int cantidadChacras;
    private int alquiler;
    private String provincia;
    private String zona;


//    INSERT INTO properties (player_id, nroCasilla, precio, cantidadChacras, alquiler, provincia, zona) VALUES (0 , 1, 1400, 0, 200, 'Mendoza', 'Sur');
//    INSERT INTO properties (player_id, nroCasilla, precio, cantidadChacras, alquiler, provincia, zona) VALUES (0, 2, 1400, 0, 300, 'Mendoza', 'Norte');
//    INSERT INTO properties (player_id, nroCasilla, precio, cantidadChacras, alquiler, provincia, zona) VALUES (0, 3, 1400, 0, 150, 'Mendoza', 'Centro');
//    INSERT INTO properties (player_id, nroCasilla, precio, cantidadChacras, alquiler, provincia, zona) VALUES (0, 4, 1400, 0, 500, 'Cordoba', 'Sur');
//    INSERT INTO properties (player_id, nroCasilla, precio, cantidadChacras, alquiler, provincia, zona) VALUES (0, 5, 1400, 0, 220, 'Cordoba', 'Norte');
//    INSERT INTO properties (player_id, nroCasilla, precio, cantidadChacras, alquiler, provincia, zona) VALUES (0, 6, 1400, 0, 150, 'Cordoba', 'Centro');
//    INSERT INTO properties (player_id, nroCasilla, precio, cantidadChacras, alquiler, provincia, zona) VALUES (0, 7, 1400, 0, 310, 'Tucuman', 'Sur');
//    INSERT INTO properties (player_id, nroCasilla, precio, cantidadChacras, alquiler, provincia, zona) VALUES (0, 8, 1400, 0, 350, 'Tucuman', 'Norte');
//    INSERT INTO properties (player_id, nroCasilla, precio, cantidadChacras, alquiler, provincia, zona) VALUES (0, 9, 1400, 0, 120, 'Tucuman', 'Centro');
}
