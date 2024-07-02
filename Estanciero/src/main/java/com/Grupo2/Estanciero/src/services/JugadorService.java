package com.Grupo2.Estanciero.src.services;

import com.Grupo2.Estanciero.src.models.Card;
import com.Grupo2.Estanciero.src.models.Casilla;
import com.Grupo2.Estanciero.src.models.Jugador;
import com.Grupo2.Estanciero.src.models.Propiedades;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service

public interface JugadorService {


    public ArrayList<Integer> tirarDdo();
    public ArrayList<Integer> mover();

    public void comprar(Casilla casilla);
    public void vender();
    public void vender(Jugador jugador);
    public void construir(ArrayList<Propiedades>pTablero);
    public void construir(ArrayList<Propiedades>pTablero, ArrayList<Casilla> lista);
    public Boolean construir(ArrayList<Propiedades>pTablero,Jugador jugador);
    public void sacarTarjeta(ArrayList<Card>lstSuerte,ArrayList<Card>lstDestino);
    public void irPreso();
    public int getIdJugador();

    public void setIdJugador(int idJugador) ;

    public String getNombre() ;

    public void setNombre(String nombre) ;

    public int getDinero();

    public void setDinero(int dinero) ;

    public ArrayList<Propiedades> getPropiedades() ;

    public void setPropiedades(ArrayList<Propiedades> propiedades) ;

    public Casilla getCasilla() ;

    public void setCasilla(Casilla casilla) ;

    public int getCapitalTotal() ;

    public void setCapitalTotal(int capitalTotal) ;
    public boolean isPreso() ;

    public void setPreso(boolean preso) ;

    public int getTurnosPreso();

    public void setTurnosPreso(int turnosPreso) ;
    public boolean getPerdio();

    public void setPerdio(boolean perdio);
    public boolean getGano();

    public void setGano(boolean gano);
    public Integer getNumeroDado();

    public void setNumeroDado(Integer numeroDado) ;
    public Integer getTurno() ;

    public void setTurno(Integer turno) ;
    public ArrayList<Integer> getDados() ;

    public void setDados(ArrayList<Integer> dados) ;
    public boolean getEsBot() ;
    public int getNumTiros() ;

    public void setNumTiros(int numTiros);
    public void setEsBot(boolean esBot) ;
    public boolean volverATirar(ArrayList<Integer>dados);
    public void alquilar(ArrayList<Jugador>listaJugadores, ArrayList<Casilla>lstCasilla);


}

