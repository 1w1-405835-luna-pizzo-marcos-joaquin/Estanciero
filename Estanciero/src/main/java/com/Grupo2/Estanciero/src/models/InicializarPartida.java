package com.Grupo2.Estanciero.src.models;

import com.Grupo2.Estanciero.src.services.JugadorService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class InicializarPartida {


    private Scanner scanner=new Scanner(System.in);
    private Validadores validador=new Validadores();
    ArrayList<Integer> listaId = new ArrayList<>();
    Random rmd = new Random();

    public InicializarPartida() {
    }

    /**se crea un jugador y se devuelve un jugador
     * requiere que se le ingrese un nombre por parametros
     */

    public Jugador crearJugador(){
        Jugador usuario;
        System.out.println("INGRESE SU NOMBRE");
        String nom=scanner.nextLine();
        usuario = new Player(nom,id(),"user");

        return usuario;
    }

    public int elegirModoJuego(){
        System.out.println("ELIJA EL MODO DE JUEGO:\n  | 1- Muerte Súbita |  <---->  | 2- Monto Ganador |");
        int modo =validador.validadorEntre(1,2);
        return modo;
    }


    public int elegirMontoGanador(int modo){
        int capitalParaGanar=0;
        if (modo==2){
            System.out.println("INGRESE EL CAPITAL TOTAL QUE DEBE ACUMULAR UN JUGADOR PARA GANAR (min:$40.000/max:$400.000)");
            capitalParaGanar=validador.validadorEntre(40000,400000);
        }
        return capitalParaGanar;
    }

    public int elegirDificultad()
    {
        System.out.println("Elija la dificultad :\n | 1 - FACIL | \n | 2 - MEDIO | \n | 3 - DIFICIL | ");
        int dificultad =validador.validadorEntre(1,3);
        return dificultad;
    }


    public ArrayList<JugadorService> crearBots(int dificultad){
        ArrayList<JugadorService>listaBots=new ArrayList<>();
        JugadorService bot1=new BotConservador("bot Conservador", id(), "conservador");
        JugadorService bot2=new BotEquilibrado("bot Equilibrado",id() , "equilibrado");
        JugadorService bot3=new BotAgresivo("bot Agresivo", id(), "agresivo");
        JugadorService bot4=new BotEquilibrado("bot Equilibrado extra", id(), "equilibrado2");

        switch (dificultad){
            case 1:  listaBots.add(bot1);
                listaBots.add(bot2);
                break;

            case 2:
                listaBots.add(bot1);
                listaBots.add(bot2);
                listaBots.add(bot3);
                break;

            case 3:
                listaBots.add(bot1);
                listaBots.add(bot2);
                listaBots.add(bot3);
                listaBots.add(bot4);
                break;
        }
        return listaBots;
    }

    public ArrayList<JugadorService> ordenarTurnos(String nombre,ArrayList<JugadorService>listaJugadores){

        asignarDado(nombre,listaJugadores);

        listaJugadores.sort(Comparator.comparing(JugadorService::getNumeroDado).reversed());


        for (int i = 0; i < listaJugadores.size(); i++) {
            listaJugadores.get(i).setTurno(i);
        }
        for (JugadorService j : listaJugadores){
            System.out.println(" \n" + j.getNombre() + " | valor de dados: " + j.getNumeroDado() + " | turno " +(j.getTurno()+1));
        }

        return listaJugadores;
    }

    private void asignarDado(String nombre, ArrayList<JugadorService>listaJugadores){
        for (JugadorService j:listaJugadores){
            if(j.getNombre() == nombre){
                System.out.println("Presione enter para tirar los dados");
                scanner.nextLine();
            }
            ArrayList<Integer>dados=j.tirarDdo();
            Integer dado1 = dados.get(0);
            Integer dado2 = dados.get(1);

            Integer valorDados=dado1+ dado2;
            System.out.println("El jugador " + j.getNombre() + " saco los dados \n" + dado1 + " " + dado2);

            j.setNumeroDado(valorDados);
        }
    }


    private int id(){
        int id;
        do {
            id = rmd.nextInt(100) + 1; // Generar número aleatorio entre 1 y 100
        } while (listaId.contains(id));
        listaId.add(id);
        return id;
    }
}
