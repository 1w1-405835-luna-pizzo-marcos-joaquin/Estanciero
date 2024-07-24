package com.Grupo2.Estanciero.src.models;

import com.Grupo2.Estanciero.src.services.JugadorService;

import java.util.ArrayList;
import java.util.List;

public class Letras {
    public void println(String texto) {
        try {
            for (int i = 0; i < texto.length(); i++) {
                System.out.print(texto.charAt(i));
                Thread.sleep(20);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------| PROPIEDADES  COMPRADAS DEL PLAYER |--------------------

    public void mostrarPropiedades(Jugador player) {
        int cardsPerRow = 4;
        List<Propiedades> propiedades = player.getPropiedades();

        for (int i = 0; i < propiedades.size(); i += cardsPerRow) {
            List<String[]> rows = buildRows(propiedades, i, Math.min(i + cardsPerRow, propiedades.size()));
            printRows(rows);
            System.out.println(); // Espacio entre filas de tarjetas
        }
    }

    private List<String[]> buildRows(List<Propiedades> propiedades, int start, int end) {
        List<String[]> rows = new ArrayList<>();

        for (int i = start; i < end; i++) {
            Propiedades p = propiedades.get(i);
            rows.add(new String[]{
                    "┌─────────────────────────────┐",
                    String.format("│ %-3d %-20s │", p.getNroCasilla(), center(p.getProvincia(), 23)),
                    String.format("│%s│", center("Zona: " + p.getZona(), 29)),
                    "├─────────────────────────────┤",
                    String.format("│ Alquiler: $%-17d│", p.getAlquiler()),
                    String.format("│ Precio venta: $%-13d│", p.getPrecio()),
                    String.format("│ Chacras: %-19d│", p.getCantidadChacras()),
                    "└─────────────────────────────┘"
            });
        }

        return rows;
    }

    private void printRows(List<String[]> rows) {
        int rowLength = rows.get(0).length;

        for (int i = 0; i < rowLength; i++) {
            for (String[] row : rows) {
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
    }

    private String center(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }

        int leftPadding = (width - text.length()) / 2;
        int rightPadding = width - text.length() - leftPadding;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leftPadding; i++) {
            sb.append(" ");
        }
        sb.append(text);
        for (int i = 0; i < rightPadding; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }

    //----------------------------------------------------------------------------------


    public void mostrarPropiedades(ArrayList<Propiedades> propiedades) {
        for (Propiedades prop : propiedades) {
            if (prop.getNroCasilla() != 8 && prop.getNroCasilla() != 12 && prop.getNroCasilla() != 16
                    && prop.getNroCasilla() != 18 && prop.getNroCasilla() != 22 && prop.getNroCasilla() != 27 && prop.getNroCasilla() != 31) {

                System.out.println(STR."\{prop.getNroCasilla()}- \{prop.getProvincia()} \{prop.getZona()}"
                        + "| Precio: $" + prop.getPrecioVenta() + "| Precio de construccion: $" + prop.getPrecioMejora());

            }
        }
    }

    public void welcome() {
        System.out.println("\n \n ");
        System.out.println("                                                             BIENVENIDO AL");
        System.out.println("                                       ___   ___ _____  ____  _    _  ___  o  ___  ___   ___  ");
        System.out.println("                                      │___  |__    │   │____│ │  / │ │	   │ │___ │___│ │   │ ");
        System.out.println("                                      |___  ___|   │   │    │ │ /  │ |___  │ |___ |  |  |___|  ");
    }

    public void dibujarDado(ArrayList<Integer> dados) {
        String[][] dado1 = obtenerDibujo(dados.get(0));
        String[][] dado2 = obtenerDibujo(dados.get(1));

        for (int i = 0; i < dado1.length; i++) {
            System.out.println(dado1[i][0] + "   " + dado2[i][0]);
        }
    }

    private String[][] obtenerDibujo(int value) {
        switch (value) {
            case 1:
                return new String[][]{
                        {"┌─────────┐"},
                        {"│         │"},
                        {"│    ●    │"},
                        {"│         │"},
                        {"└─────────┘"}
                };
            case 2:
                return new String[][]{
                        {"┌─────────┐"},
                        {"│ ●       │"},
                        {"│         │"},
                        {"│       ● │"},
                        {"└─────────┘"}
                };
            case 3:
                return new String[][]{
                        {"┌─────────┐"},
                        {"│ ●       │"},
                        {"│    ●    │"},
                        {"│       ● │"},
                        {"└─────────┘"}
                };
            case 4:
                return new String[][]{
                        {"┌─────────┐"},
                        {"│ ●     ● │"},
                        {"│         │"},
                        {"│ ●     ● │"},
                        {"└─────────┘"}
                };
            case 5:
                return new String[][]{
                        {"┌─────────┐"},
                        {"│ ●     ● │"},
                        {"│    ●    │"},
                        {"│ ●     ● │"},
                        {"└─────────┘"}
                };
            case 6:
                return new String[][]{
                        {"┌─────────┐"},
                        {"│ ●     ● │"},
                        {"│ ●     ● │"},
                        {"│ ●     ● │"},
                        {"└─────────┘"}
                };
            default:
                return new String[][]{
                        {"Invalid"},
                        {"dice"},
                        {"value"}
                };
        }
    }

    public void mostrarCasillaActual(ArrayList<Casilla> lstCasilla, Jugador jugador) {
        for (Casilla c : lstCasilla) {
            if (c.getNum_casilla() == jugador.getCasilla().getNum_casilla()) {
                if (c.getPropiedad() != null) {
                    System.out.println(STR."Avanzaste a la casilla \{c.getNum_casilla()} | \{c.getPropiedad().getProvincia()} Zona \{c.getPropiedad().getZona()} - Precio: $\{c.getPropiedad().getPrecio()}");
                } else {
                    switch (c.getNum_casilla()) {
                        case 7:
                            System.out.println(STR."Avanzaste a la casilla \{c.getNum_casilla()} | 'Premio ganadero'");
                            break;
                        case 21:
                        case 28:
                            System.out.println(STR."Avanzaste a la casilla \{c.getNum_casilla()} | 'Descanso'");
                            break;
                        case 4:
                            System.out.println(STR."Avanzaste a la casilla \{c.getNum_casilla()} | 'Impuestos a los réditos'");
                            break;
                        case 41:
                            System.out.println(STR."Avanzaste a la casilla \{c.getNum_casilla()} | 'Impuestos a las ventas'");
                            break;
                        case 10:
                        case 35:
                            System.out.println(STR."Avanzaste a la casilla \{c.getNum_casilla()} | 'Destino'");
                            break;
                        case 15:
                        case 36:
                            System.out.println(STR."Avanzaste a la casilla \{c.getNum_casilla()} | 'Suerte'");
                            break;
                        case 14:
                            System.out.println(STR."Avanzaste a la casilla \{c.getNum_casilla()} | 'Carcel'");
                            break;
                        default:
                            System.out.println(STR."Avanzaste a la casilla \{c.getNum_casilla()}");
                            break;
                    }
                }
            }
        }
    }

    public void mostrarTurnoJugador(Jugador jugador) {
        System.out.println("--------------------------------------------------------------------------------------------------");
        println(STR."Es tu turno \{jugador.getNombre()}. Dinero disponible:  $\{jugador.getDinero()} | Capital total:$\{jugador.getCapitalTotal()}");
        System.out.println("--------------------------------------------------------------------------------------------------");

    }

    public void mostrarMenu(ArrayList<Casilla> lstCasillas, Jugador jugador) {
        for (Casilla c : lstCasillas) {
            if (c.getNum_casilla() == jugador.getCasilla().getNum_casilla()) {
                if (c.getPropiedad() != null && c.getPropiedad().getIdPropietrio() == 0) {
                    System.out.println("\n--------------------------------------------------------------------------------------------------");
                    println("1 - Comprar esta casilla \n" +
                            "2 - Ver Propiedades y sus opciones \n" +
                            "3 - Ver estado de los bots  \n" +
                            "4 - Terminar turno \n" +
                            "5 - Abandonar partida");
                    System.out.println("--------------------------------------------------------------------------------------------------");
                } else if (c.getPropiedad() != null && c.getPropiedad().getIdPropietrio() == jugador.getIdJugador()) {
                    System.out.println("\n--------------------------------------------------------------------------------------------------");

                    println("1 - Opcion no valida, ya compraste esta casilla \n" +
                            "2 - Ver Propiedades y sus opciones \n" +
                            "3 - Ver estado de los bots  \n" +
                            "4 - Terminar turno \n" +
                            "5 - Abandonar partida");
                    System.out.println("--------------------------------------------------------------------------------------------------");

                } else if (c.getPropiedad() == null) {
                    System.out.println("\n--------------------------------------------------------------------------------------------------");

                    println("1 - Opcion no valida, no se puede comprar esta casilla \n" +
                            "2 - Ver Propiedades y sus opciones \n" +
                            "3 - Ver estado de los bots  \n" +
                            "4 - Terminar turno \n" +
                            "5 - Abandonar partida");
                    System.out.println("--------------------------------------------------------------------------------------------------");

                } else {
                    System.out.println("\n--------------------------------------------------------------------------------------------------");

                    println("1 - Opcion no valida, esta casilla ya pertenece a otro jugador \n" +
                            "2 - Ver Propiedades y sus opciones \n" +
                            "3 - Ver Estado de los bots  \n" +
                            "4 - Terminar turno \n" +
                            "5 - Abandonar partida");
                    System.out.println("--------------------------------------------------------------------------------------------------");

                }

            }
        }
    }

    public void irPreso() {
        System.out.println("  Eres un criminal, te mandaron a la carcel.");
        System.out.println("░░░███████████████████████████████████████░░░");
        System.out.println("░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░");
        System.out.println("░░█░░░░█▀█░░█▀█░░█░░░░▀░░█▀▀░░▀░░░▐▀▀▌░░░░█░░");
        System.out.println("░█░░░░░█▄█░░█░█░░█░░░░█░░█░░░░█░░░█▄▄█░░░░░█░");
        System.out.println("░░█░░░░█░░░░█▄█░░█▄▄░░█░░█▄▄░░█░░▐▌░░▐▌░░░█░░");
        System.out.println("░░█░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█░░");
        System.out.println("░░░███████████████████████████████████████░░░");
        System.out.println("░░░█═════════════════════════════════════█░░░");
        System.out.println("░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░");
        System.out.println("░░░░███░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░███░░░░");
        System.out.println("░░░░█████████████████████████████████████░░░░");
        System.out.println("░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░███░░░░");
        System.out.println("░░░██░░░░░░▀▀▀▄▄░░░░░░░░░░░░░▄▄▀▀▀░░░░░░██░░░");
        System.out.println("░░░██░░░░░░░░░░░▀▄░░░░░░░░░▄▀░░░░░░░░░░░██░░░");
        System.out.println("░░░██░░░░░░████░░░▀░░░░░░░▀░░░████░░░░░░██░░░");
        System.out.println("░░░██░░░░░░████░░░░░░░░░░░░░░░████░░░░░░██░░░");
        System.out.println("░░░░█░░░░░░░░░░░░░░░░▄▄▄░░░░░░░░░░░░░░░░█░░░░");
        System.out.println("░░░░█░░░░░░░░░░░░░░░▀▀▀▀▀░░░░░░░░░░░░░░░█░░░░");
        System.out.println("░░░░█░░░░░░░░▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄░░░░░░░░█░░░░");
        System.out.println("░░░░█░░░░░░░▄█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█▄░░░░░░░█░░░░");
        System.out.println("░░░░█░░░░░░░▀░░░░░░░░░░░░░░░░░░░▀░░░░░░░█░░░░");
        System.out.println("░░░░██░░░░░░░░░▄█████████████▄░░░░░░░░░██░░░░");
        System.out.println("░░░░░███░░░░░░█▀░░░░░░░░░░░░░▀█░░░░░░███░░░░░");
        System.out.println("░░░░░░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░░░░░░");
        System.out.println("░░░░░░░░░███████████████████████████░░░░░░░░░");
    }

    public void mostrarEstadoBots(ArrayList<Jugador> lstJugadores, Jugador usuario) {
        for (Jugador j : lstJugadores) {
            if (j != usuario) {
                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.println(j.getNombre() + "----| Dinero actual ->$" + j.getDinero() + " |--| Capital total ->$" + j.getCapitalTotal());
                System.out.println("Propiedades:");
                for (Propiedades p : j.getPropiedades()) {
                    System.out.println(p.getProvincia() + " " + p.getZona());
                }
                System.out.println("--------------------------------------------------------------------------------------------------");
            }
        }
    }

    public void mensajeFinal(ArrayList<Jugador> lstJugadores) {
        for (Jugador j : lstJugadores) {
            if (j.getGano()) {
                System.out.println(STR."El jugador ganador es \{j.getNombre()}! El dinero total acumulado fue de $\{j.getCapitalTotal()}");
            } else {
                System.out.println(STR."El jugador \{j.getNombre()} no logro ganar esta vez. Su dinero total fue de $\{j.getCapitalTotal()}");
            }
        }
    }
}
