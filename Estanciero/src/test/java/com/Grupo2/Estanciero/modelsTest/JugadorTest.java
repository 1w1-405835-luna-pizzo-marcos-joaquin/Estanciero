package com.Grupo2.Estanciero.modelsTest;

import com.Grupo2.Estanciero.src.models.Card;
import com.Grupo2.Estanciero.src.models.Casilla;
import com.Grupo2.Estanciero.src.models.Jugador;
import com.Grupo2.Estanciero.src.models.Propiedades;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.util.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JugadorTest {


    @Mock
    private ArrayList<Propiedades> propiedadesMock;
    @Mock
    private Casilla casillaMock;

    @Mock
    private Jugador propietario;

    @Spy
    private Jugador jugador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void tirarDdo() {
        List<Integer> dadosTirados = jugador.tirarDdo();
        List<Integer> comparador = Arrays.asList(1, 2, 3, 4, 5, 6);
        Boolean dicesExist = false;
        Integer dado1 = dadosTirados.get(0);
        Integer dado2 = dadosTirados.get(1);

        for (int i = 0; i < 6; i++) {
            if (dado1 == (comparador.get(i) + 1)) {
                continue;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (dado2 == (comparador.get(i) + 1)) {
                dicesExist = true;
            }
        }
        assertTrue(dicesExist);
    }

    @Test
    void mover() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        jugador.mover();

        if (jugador.getCasilla().getNum_casilla() == 42) {
            assertTrue(out.toString().contains("Paso por la salida, cobro $5.000!"));
        }
        if (jugador.getCasilla().getNum_casilla() == 35) {
            assertTrue(out.toString().contains("Se envio a"));
        }
        if (jugador.getCasilla().getNum_casilla() == 7) {
            assertTrue(out.toString().contains("Premio ganadero,"));
        }
        if (jugador.getCasilla().getNum_casilla() == 28) {
            assertTrue(out.toString().contains("Esta en una casilla de descanso"));
        }
        if (jugador.getCasilla().getNum_casilla() == 21) {
            assertTrue(out.toString().contains("Esta en una casilla de descanso"));
        }
        if (jugador.getCasilla().getNum_casilla() == 4) {
            assertTrue(out.toString().contains("Pago impuestos"));
        }
        if (jugador.getCasilla().getNum_casilla() == 41) {
            assertTrue(out.toString().contains("Pago impuestos"));
        }
    }

    @Test
    void volverATirar() {
        ArrayList<Integer> dados1 = new ArrayList<>();
        dados1.add(1);
        dados1.add(1);
        assertEquals(dados1.get(0), dados1.get(1));

        boolean result = jugador.volverATirar(dados1);
        assertTrue(result);
    }

    @Test
    void venderTest() {
        Jugador jugador = new Jugador();
        jugador.setPropiedades(propiedadesMock);

        Propiedades propiedad = new Propiedades();
        propiedad.setPrecioVenta(100);

        // Configurar el mock para que devuelva la propiedad simulada
        when(propiedadesMock.getFirst()).thenReturn(propiedad);

        // Setear el dinero en 0
        jugador.setDinero(0);
        jugador.setCapitalTotal(0);

        // Ejecutar el método vender
        jugador.vender();

        // Verificar que la venta se haya realizado correctamente
        assertEquals(100, jugador.getDinero());
        assertEquals(100, jugador.getCapitalTotal());

        // Verificar que la propiedad se ha eliminado de la lista
        verify(propiedadesMock).remove(propiedad);
    }

    @Test
    void sacarTarjetaSuerte() {
        Card cardS = new Card();
        cardS.setAccion("suma");
        cardS.setValor(150);
        cardS.setDescripcion("test exitoso");

        Card cardD = new Card();
        cardD.setAccion("suma");
        cardD.setValor(0);

        ArrayList<Card> lstSuerte = new ArrayList<>();
        lstSuerte.add(cardS);
        ArrayList<Card> lstDestino = new ArrayList<>();
        lstDestino.add(cardD);

        when(casillaMock.getNum_casilla()).thenReturn(15);

        jugador.setDinero(0);
        jugador.setCasilla(casillaMock);

        jugador.sacarTarjeta(lstSuerte, lstDestino);

        assertEquals(150, jugador.getDinero());
    }

    @Test
    void sacarTarjetaDestino() {
        Card cardS = new Card();
        cardS.setAccion("suma");
        cardS.setValor(0);


        Card cardD = new Card();
        cardD.setAccion("suma");
        cardD.setDescripcion("test exitoso");
        cardD.setValor(150);

        ArrayList<Card> lstSuerte = new ArrayList<>();
        lstSuerte.add(cardS);
        ArrayList<Card> lstDestino = new ArrayList<>();
        lstDestino.add(cardD);

        when(casillaMock.getNum_casilla()).thenReturn(10);

        jugador.setDinero(0);
        jugador.setCasilla(casillaMock);

        jugador.sacarTarjeta(lstSuerte, lstDestino);

        assertEquals(150, jugador.getDinero());
    }

    @Test
    void irPresoTest() {
        Jugador jugador = new Jugador();
        jugador.irPreso();

        assertTrue(jugador.isPreso());
        assertEquals(3, jugador.getTurnosPreso());
    }

    @Test
    void alquilarTest() {

        propietario.setIdJugador(2);
        propietario.setDinero(0);

        Propiedades p = new Propiedades();
        p.setAlquiler(150);
        p.setNroCasilla(1);
        p.setIdPropietrio(2);

        ArrayList<Jugador> lstJugadores = new ArrayList<>();
        ArrayList<Casilla> lstCasilla = new ArrayList<>();

        lstCasilla.add(casillaMock);
        lstJugadores.add(propietario);

        when(casillaMock.getNum_casilla()).thenReturn(1);
        when(casillaMock.getPropiedad()).thenReturn(p);
        when(casillaMock.getPropiedad()).thenReturn(p).thenReturn(p).thenReturn(p);
        when(casillaMock.getPropiedad()).thenReturn(p);
        when(jugador.getCasilla()).thenReturn(casillaMock);
        when(jugador.getIdJugador()).thenReturn(1);
        when(jugador.getDinero()).thenReturn(300).thenReturn(300);
        when(jugador.getNombre()).thenReturn("juan");
        when(propietario.getIdJugador()).thenReturn(2);
        when(propietario.getDinero()).thenReturn(0);
        when(propietario.getNombre()).thenReturn("pedro");

        jugador.alquilar(lstJugadores, lstCasilla);

        verify(jugador).setDinero(300 - 150);
        verify(propietario).setDinero(300 - 150);


    }

    @Test
    void pagarTest() {
        int monto = 100;
        ArrayList<Propiedades> empty = new ArrayList<>();

        when(jugador.getDinero()).thenReturn(50);
        when(jugador.getPropiedades()).thenReturn(empty);

        jugador.pagar(monto);

        verify(jugador).setPerdio(true);
    }

}
