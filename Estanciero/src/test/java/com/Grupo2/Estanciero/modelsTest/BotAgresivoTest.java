package com.Grupo2.Estanciero.modelsTest;

import com.Grupo2.Estanciero.src.models.Casilla;
import com.Grupo2.Estanciero.src.models.Jugador;
import com.Grupo2.Estanciero.src.models.Propiedades;
import com.Grupo2.Estanciero.src.models.Validadores;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class BotAgresivoTest {
    @Mock
    private ArrayList<Propiedades> propiedadesMock;
    @Mock
    private Casilla casillaMock;
    @Spy
    Propiedades p;

    @Mock
    private Jugador propietario;
    @Mock
    Validadores validadores;

    @Spy
    @InjectMocks
    private Jugador jugador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void construirTest() {

        ArrayList<Propiedades> lstP = new ArrayList<>();
        lstP.add(p);

        ArrayList<Propiedades> propTablero = new ArrayList<>();
        ArrayList<Casilla> lstCasilla = new ArrayList<>();

        when(jugador.getPropiedades()).thenReturn(lstP);
        when(jugador.getDinero()).thenReturn(500);
        when(p.getPrecioMejora()).thenReturn(150);
        when(p.getPrecioVenta()).thenReturn(50);
        when(validadores.seTienenTodasZonas(propTablero, lstP, p)).thenReturn(true);
        when(p.getCantidadChacras()).thenReturn(1).thenReturn(1);

        jugador.construir(propTablero, lstCasilla);

        verify(p).setCantidadChacras(1 + 1);
        verify(jugador).setDinero(500 - 150);
        verify(p).setPrecioVenta(50 + (150 / 2));


    }

}
