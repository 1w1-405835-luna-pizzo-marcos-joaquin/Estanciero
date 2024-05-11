package Src.Model;

import Src.Model.IJugador;

public class Tablero implements IJugador{
    private int id_modo;

    private int id_dificultad;

    public int getId_modo() {
        return id_modo;
    }

    public void setId_modo(int id_modo) {
        this.id_modo = id_modo;
    }

    public int getId_dificultad() {
        return id_dificultad;
    }

    public void setId_dificultad(int id_dificultad) {
        this.id_dificultad = id_dificultad;
    }


    public Tablero(int id_modo, int id_dificultad) {
        this.id_modo = id_modo;
        this.id_dificultad = id_dificultad;
    }

    @Override
    public void TirarDdo() {

    }

    @Override
    public void Mover() {

    }

    @Override
    public void Comprar() {

    }

    @Override
    public void Vender() {

    }

    @Override
    public void Hipotecar() {

    }

    @Override
    public void Construir() {

    }

    @Override
    public void sacaTarjeta() {

    }

    @Override
    public void irPreso() {

    }
}
