package com.Grupo2.Estanciero.modelsTest;

import com.Grupo2.Estanciero.src.models.*;
import com.Grupo2.Estanciero.src.services.CardService;
import com.Grupo2.Estanciero.src.services.JugadorService;
import com.Grupo2.Estanciero.src.services.MatchService;
import com.Grupo2.Estanciero.src.services.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TableroTest {

    @Mock
    private PropertyService propertyService;

    @Mock
    private MatchService matchService;

    @Mock
    private Validadores validador;

    @Mock
    private CardService cardService;

    @Mock
    private Scanner scanner;

    @Mock
    private InicializarPartida incializador;

    @InjectMocks
    private Tablero tablero;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInciarPartida() {
    }

    @Test
    void inciarPartida() {

    }

    @Test
    void crearPartida() {

    }

    @Test
    void jugarRonda() {
    }

    @Test
    void mostrarMenu() {
    }

    @Test
    void terminoElJuego() {
    }

    @Test
    void jugarDeNuevo() {
    }

    @Test
    @Tag("Muerte subita")
    void muerteSubita_listaNula() {
        //Configuro que la lista jugadora sea null
        tablero.setListaJugadores(null);

        //llamamos al metodo
        boolean resultado = tablero.muerteSubita();

        //Verificar resultado
        assertFalse(resultado, "Cuando la lista de jugadores es nula, el metodo debe devolver false");
    }

    @Test
    @Tag("Muerte subita")
    void muerteSubita_listaVacia() {
        // Configurar el escenario: listaJugadores es una lista vacía
        tablero.setListaJugadores(new ArrayList<>());

        // Ejecutar el método
        boolean resultado = tablero.muerteSubita();

        // Verificar el resultado
        assertFalse(resultado, "cuando la lista de jugadores esta vacia, debe devolver false");

    }

    @Test
    @Tag("Muerte subita")
    void muerteSubita_unJugadorNoPerdio() {
        JugadorService jugador = mock(JugadorService.class);
        when(jugador.getPerdio()).thenReturn(false);

        ArrayList<JugadorService> listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador);

        tablero.setListaJugadores(listaJugadores);

        boolean resultado = tablero.muerteSubita();

        assertTrue(resultado, "Cuando hay un solo jugador que no perdio, el metodo debe devolver true");
    }

    @Test
    void montoGanador() {
    }

    @Test
    @Tag("Test crear partida - Flujo basico")
    void testCrearPartida() {
    }

    @Test
    @Disabled
    @Tag(" Test Inicializar casillas")
    void crearCasillas() {

        // Crear propiedades de prueba
        List<Propiedades> propiedades = new ArrayList<>();
        for (int i = 0; i < 42; i++) {
            Propiedades propiedad = new Propiedades();
            propiedad.setNroCasilla(i);
            propiedades.add(propiedad);
        }


        // Configurar el mock para devolver las propiedades de prueba
        when(propertyService.getAllproperties()).thenReturn((ArrayList<Propiedades>) propiedades);

        // Llamar al método a probar
        tablero.crearCasillas();

        // Verificar que se han creado 42 casillas
        List<Casilla> listaCasillas = tablero.getListaCasillas();
        assertEquals(42, listaCasillas.size());

        // Verificar que las propiedades se asignaron correctamente
        for (Propiedades propiedad : propiedades) {
            Casilla casilla = listaCasillas.get(propiedad.getNroCasilla());
            assertEquals(propiedad, casilla.getPropiedad());
        }

    }

    @Test
    @Disabled
    @Tag("Agregar Tarjetas Y Ser Mezcladas")
    void crearCard() {
        //crea cartas de prueba
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            Card card = new Card();
            card.setTipo(i < 16 ? "suerte" : "destino");
            cards.add(card);
        }

        // Configurar el mock para devolver las cartas de prueba
        when(cardService.getAll()).thenReturn((ArrayList<Card>) cards);

        //when(scanner.nextLine()).thenReturn("n");
        tablero.crearCard();

        List<Card> listaSuerte = tablero.getListaSuerte();
        List<Card> listaDestino = tablero.getListaDestino();
        assertEquals(16, listaSuerte.size());
        assertEquals(16, listaDestino.size());

        List<Card> cardsSuerteAntesMezcla = new ArrayList<>(tablero.getListaDestino());
        List<Card> cardsDestinoAntesMezcla = new ArrayList<>(tablero.getListaSuerte());

        Collections.shuffle(listaSuerte);
        Collections.shuffle(listaDestino);

        assertNotEquals(cardsSuerteAntesMezcla, listaSuerte);
        assertNotEquals(cardsDestinoAntesMezcla, listaDestino);
    }
}
