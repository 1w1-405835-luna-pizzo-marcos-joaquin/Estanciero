package com.Grupo2.Estanciero.src.models;

import com.Grupo2.Estanciero.src.services.CardService;
import com.Grupo2.Estanciero.src.services.JugadorService;
import com.Grupo2.Estanciero.src.services.MatchService;
import com.Grupo2.Estanciero.src.services.PropertyService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.*;

@Getter
@Setter
@Component
public class Tablero {
    Scanner scanner = new Scanner(System.in);
    private int id_modo;
    private int id_dificultad;
    private int capitalParaGanar;
    private ArrayList<JugadorService> listaJugadores;
    private ArrayList<Card> listaSuerte;
    private ArrayList<Card> listaDestino;
    private ArrayList<Casilla> listaCasillas;
    private Validadores validador = new Validadores();
    private InicializarPartida incializador = new InicializarPartida();
    private Letras letras = new Letras();
    private Jugador usuario = new Jugador();
    private Match match = new Match();
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_CYAN = "\u001B[36m";

    public Tablero() {
        listaSuerte = new ArrayList<>();
        listaDestino = new ArrayList<>();
        listaJugadores = new ArrayList<>();
        listaCasillas = new ArrayList<>();
        id_modo = 0;
        id_dificultad = 0;
    }

    @Autowired
    MatchService matchService;

    @Autowired
    PropertyService propertyService;

    @Autowired
    CardService cardService;

    public void jugarRonda() {
        do {
            //   precioConChacra();
            for (Jugador jugador : match.getPlayers()) {

                if (jugador.getNombre() == usuario.getNombre()) {

                    int seleccion = 0;
                    ArrayList<Integer> dadosTirados;

                    do {
                        System.out.println(ANSI_CYAN + "==========================================================================================================" + ANSI_RESET);

                        System.out.println(STR."Es tu turno \{usuario.getNombre()}");

                        dadosTirados = jugador.mover();

                        jugador.sacarTarjeta(listaSuerte, listaDestino);

                        jugador.alquilar(match.getPlayers(), listaCasillas);

                        letras.mostrarCasillaActual(listaCasillas, jugador);

                        do {
                            letras.mostrarTurnoJugador(jugador);
                            letras.mostrarMenu(listaCasillas, jugador);
                            try {
                                seleccion = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                                scanner.next();
                                continue;
                            }

                            switch (seleccion) {
                                case 1://buscar en la lista de casillas del tablero cual
                                    // es la casilla en la que se encuentra el jugador
                                    for (Casilla c : listaCasillas) {
                                        //comprar la casilla en la que se encuentra
                                        if (c.getPropiedad() != null && c.getNum_casilla() == jugador.getCasilla().getNum_casilla()) {

                                            jugador.comprar(c);

                                            long idProperty = c.getPropiedad().getIdPropiedad();
                                            propertyService.updateProperties(idProperty, jugador.getIdJugador());

                                        }
                                    }
                                    break;
                                case 2://Muestre las Propiedades
                                    mostrarSubmenuPropiedades();
                                    break;
                                //Valor
                                case 3:
                                    letras.mostrarEstadoBots(match.getPlayers(), jugador);
                                    break;
                                case 4:
                                    break;


                                case 5:
                                    System.out.println("Esta seguro que quiere abandonar?(Y/n)");
                                    scanner.nextLine();
                                    String respuesta = scanner.nextLine();
                                    if (validador.getYesNoAnswer(respuesta)) {
                                        System.exit(0);
                                    }

                                default:
                                    letras.println("Opción no valida.");
                            }
                        } while (seleccion != 4);
                        System.out.println(ANSI_CYAN + "==========================================================================================================" + ANSI_RESET);

                    } while (jugador.volverATirar(dadosTirados));

                } else {
                    if (!jugador.getPerdio()) {
                        ArrayList<Integer> dadosTirados;
                        do {
                            System.out.println(ANSI_YELLOW + "==========================================================================================================" + ANSI_RESET);
                            letras.println("es el turno de " + jugador.getNombre());
                            dadosTirados = jugador.mover();
                            jugador.sacarTarjeta(listaSuerte, listaDestino);
                            jugador.alquilar(match.getPlayers(), listaCasillas);

                            for (Casilla c : listaCasillas) {
                                //comprar la casilla en la que se encuentra
                                if (c.getPropiedad() != null && c.getNum_casilla() == jugador.getCasilla().getNum_casilla()) {

                                    jugador.comprar(c);

                                    long idProperty = c.getPropiedad().getIdPropiedad();
                                    propertyService.updateProperties(idProperty, jugador.getIdJugador());

                                }
                            }
                            jugador.construir(propertyService.getAllproperties());
                            System.out.println(ANSI_YELLOW + "==========================================================================================================" + ANSI_RESET);

                            // TODO no se si aca se tiene que actualizar las property service
                        } while (jugador.volverATirar(dadosTirados));
                    }

                }
                for (Casilla c : listaCasillas) {
                    if (c.getPropiedad() != null) {
                        long id = c.getPropiedad().getIdPropiedad();
                        propertyService.updatePropertiesChacras(id, c.getPropiedad().getCantidadChacras());
                    }
                }
                matchService.updateMatch(match);
            }
        }
        while (!terminoElJuego(match.getModo()));

        letras.mensajeFinal(match.getPlayers());

    }


    private void mostrarSubmenuPropiedades() {
        boolean enSubmenu = true;
        int opcionSubmenu = -1;
        while (enSubmenu) {

            System.out.println("--------------------------------------------------------------------------------------------------");
            // Letras.println(STR."Propiedades: \{usuario.getPropiedades().toString()}");//mostrar propieedades
            //mostrar todas las propiedades que tiene el jugador con su numero de casilla

            Jugador jugador = new Jugador();
            for (Jugador player : match.getPlayers()) {
                if (player.getTipo().equals("user")) {
                    letras.mostrarPropiedades(player);
                    jugador = player;
                }
            }

            letras.println("1- Vender Propiedad");
            letras.println("2- Construir");
            letras.println("3- Volver al Menú Principal");
            System.out.println("--------------------------------------------------------------------------------------------------");
            try {
                opcionSubmenu = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
                continue;
            }

            switch (opcionSubmenu) {
                case 1:// metodinho vender propiedad
                    usuario.vender(jugador);
                    break;
                case 2:
                    if (usuario.construir(propertyService.getAllproperties(), jugador)) {
                        precioConChacra();
                    }

                    break;
                case 3:
                    enSubmenu = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        }
    }


    public boolean terminoElJuego(int id_modo) {
        boolean termino = switch (match.getModo()) {
            case 1 -> //muerte subita: El juego termina cuando todos los jugadores
                //menos uno se quedan sin dinero.
                    muerteSubita();
            case 2 -> //monto ganador: el juego termina cuando todos los jugadores menos uno se
                //quedan sin dinero o cuando un jugador alcanza un capital total determinado
                    montoGanador();
            default -> false;
        };
        return termino;
    }

    //
    public Boolean jugarDeNuevo() {
        Boolean answer = null;
        do {
            letras.println("Volver a Jugar (y/n)");
            String input = scanner.nextLine();
            answer = validador.getYesNoAnswer(input);
        } while (answer == null);
        return answer;
    }

    /**
     * Este metodo valida que todos los jugadores menos uno hayan perdido
     */
    public boolean muerteSubita() {
        boolean termino = false;
        int cantidadJugadores = match.getPlayers().size();
        int perdieron = 0;
        for (Jugador jugador : match.getPlayers()) {
            if (jugador.getTipo().equals("user") && jugador.getPerdio()) {
                return true;
            } else if (jugador.getPerdio()) {
                perdieron++;
            }
        }
        if (perdieron == cantidadJugadores - 1) {
            termino = true;
        }
        return termino;
    }

    /**
     * Este metodo valida si un jugador alcanzo el monto de capital establecido
     * para ganar o si ya perdieron todos los demas jugadores menos uno.
     */
    public boolean montoGanador() {
        boolean termino = false;
        for (Jugador jugador : match.getPlayers()) {
            if (jugador.getCapitalTotal() >= match.getMontoGanador() || muerteSubita()) {
                jugador.setGano(true);
                return true;
            }
        }
        return termino;
    }

    public void inciarPartida() {

        //propertyService.deleteAll();
        precioConChacra();
        crearCasillas();
        crearCard();

        if (esxistMatch()) {

            match = matchService.getMatch();
            System.out.println("       \n  TIENES UNA PARTIDA GUARDADA \n DESEAS CONTINUARLA ? ( Y/N )");
            boolean respuesta = validador.getYesNoAnswer(scanner.nextLine());
            if (respuesta) {
                System.out.println("  \n  CARGANDO PARTIDA .......");
                asignarProperties();
                for (Jugador j : match.getPlayers()) {
                    if (Objects.equals(j.getTipo(), "user")) {
                        usuario = j;
                    }
                }
            } else {

                matchService.deleteMatch(match.getId());
                resetProperties();
                crearPartida();
                crearCasillas();
            }
        } else {
            resetProperties();
            crearPartida();
        }
    }

    public void crearPartida() {

        //crear jugador
        usuario = incializador.crearJugador();
        listaJugadores.add(usuario);
        //elegir modo de juego
        id_modo = incializador.elegirModoJuego();
        capitalParaGanar = incializador.elegirMontoGanador(id_modo);
        //elegir dificultad
        int dificultad = incializador.elegirDificultad();
        //crear bots
        listaJugadores.addAll(incializador.crearBots(dificultad));
        //ordenar turnos
        incializador.ordenarTurnos(usuario.getNombre(), listaJugadores);

        matchService.createMatch(listaJugadores, dificultad, id_modo, capitalParaGanar);

        match = matchService.getMatch();

    }


    public boolean esxistMatch() {
        Match match = matchService.getMatch();

        if (match.getMatchStatus() == MatchStatus.PLAYING) {

            return true;
        }
        return false;
    }


    public void crearCasillas() {
        ArrayList<Propiedades> propiedades = propertyService.getAllproperties();
        listaCasillas.clear();
        int nroPropiedad = 0;


        for (int i = 0; i < 42; i++) {

            Propiedades p = propiedades.get(nroPropiedad);
            Casilla casilla = new Casilla();
            casilla.setNum_casilla(i);

            if (p.getNroCasilla() == i) {
                casilla.setPropiedad(p);
                listaCasillas.add(casilla);
                if (nroPropiedad < 28) {
                    nroPropiedad++;
                }
            } else {
                listaCasillas.add(casilla);
            }
        }

    }


    public void crearCard() {

        ArrayList<Card> cards = cardService.getAll();

        for (Card c : cards) {
            if (c.getTipo().equals("suerte")) {
                listaSuerte.add(c);
            } else {
                listaDestino.add(c);
            }
        }
        Collections.shuffle(listaSuerte);
        Collections.shuffle(listaDestino);
    }


    public void asignarProperties() {
        for (Casilla c : listaCasillas) {
            for (Jugador j : match.getPlayers()) {
                if (c.getPropiedad() != null && c.getPropiedad().getIdPropietrio() == j.getIdJugador()) {
                    j.getPropiedades().add(c.getPropiedad());
                }
            }
        }
    }

    public void resetProperties() {
        for (Casilla c : listaCasillas) {
            if (c.getPropiedad() != null) {
                Propiedades p = c.getPropiedad();
                long id = p.getIdPropiedad();
                propertyService.updateProperties(id, 0);
                propertyService.updatePropertiesChacras(id, 0);
            }
        }
    }

    public void precioConChacra() {
        for (Casilla c : listaCasillas) {
            if (c.getPropiedad() != null && c.getPropiedad().getCantidadChacras() > 0) {

                c.getPropiedad().setPrecioVenta(c.getPropiedad().getPrecioVenta() + (c.getPropiedad().getPrecioMejora() / 2));

                //Aumentamos el valor del alquiler inversamente proporcional a la cantidad de chacras

                int incremento = c.getPropiedad().getAlquiler() * (1 / c.getPropiedad().getCantidadChacras());
                c.getPropiedad().setAlquiler(c.getPropiedad().getAlquiler() + incremento);

            }
        }

    }

}