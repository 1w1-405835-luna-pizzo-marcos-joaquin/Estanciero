package com.Grupo2.Estanciero.modelsTest;

import com.Grupo2.Estanciero.src.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {
    private Player jugador;
    private Scanner scannerMock;
    private Validadores validadorMock;
    private Letras letrasMock;

    @BeforeEach
    public void setUp() {
        scannerMock = mock(Scanner.class);
        validadorMock = mock(Validadores.class);
        letrasMock = mock(Letras.class);
        jugador = new Player();
        jugador.setScanner(scannerMock);
        jugador.setValidador(validadorMock);
        jugador.setLetras(letrasMock);
    }

    @Test
    public void testVenderPropiedad() {

        // Seteo una lista de propiedades con una prpiedad con el id del jugador
        ArrayList<Propiedades> propiedades = new ArrayList<>();
        Propiedades propiedad1 = new Propiedades(1, 1, 1, 500, 50, 0, 100, 250, "Cordoba", "Norte");
        propiedad1.setIdPropietrio(1);
        propiedades.add(propiedad1);

        //le cargo al jugador la lista de propiedades
        jugador.setPropiedades(propiedades);

        // Simulación de entradas de usuario
        when(scannerMock.nextLine()).thenReturn("Y", "1", "Y");
        when(validadorMock.getYesNoAnswer(anyString())).thenReturn(true);
        when(validadorMock.validadorNumero()).thenReturn(1);

        jugador.vender();

        // Verificaciones
        assertEquals(35250, jugador.getDinero()); // Dinero después de la venta
        assertEquals(35250, jugador.getCapitalTotal()); // Capital total después de la venta
        assertTrue(jugador.getPropiedades().isEmpty()); // La propiedad debe haber sido removida
        assertEquals(-1, propiedad1.getIdPropietrio()); // La propiedad ya no tiene propietario

        verify(letrasMock).println("Propiedad vendida");
    }

    @Test
    public void testCancelarVenta() {
        // Simulación de entradas de usuario para cancelar la venta
        when(scannerMock.nextLine()).thenReturn("N");
        when(validadorMock.getYesNoAnswer(anyString())).thenReturn(false);

        jugador.vender();

        // Verificaciones
        verify(letrasMock).println("Quiere continuar en el menu de venta? (Y/n)");
    }
}

