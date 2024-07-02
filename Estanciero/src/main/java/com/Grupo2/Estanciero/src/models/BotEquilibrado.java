package com.Grupo2.Estanciero.src.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BotEquilibrado extends Jugador {
    private int contador;
    private Validadores validador=new Validadores();
    public BotEquilibrado() {
        super();
    }

    public BotEquilibrado(String nom, int id, String tipo) {
        super(nom, id, tipo);
        contador = 0;
    }

    @Override
    public void comprar(Casilla casilla) {

        if (casilla.getPropiedad()!=null){
            String provincia = casilla.getPropiedad().getProvincia().toLowerCase();
            //se valida que la casilla sea del tipo propiedad
            /**Se valida que tenga dinero y que no tenga propietario la casilla*/
            if (getDinero() >= casilla.getPropiedad().getPrecio() &&
                    casilla.getPropiedad().getIdPropietrio() == 0) {
                /**Se valida que el nro de provincia coincida con el de preferencia*/
                if (provincia.equals("mendoza")||provincia.equals("santa fe")||provincia.equals("tucuman")) {
                    //Se setea un propietario a la casilla
                    casilla.getPropiedad().setIdPropietrio(getIdJugador());
                    //se resta al dinero total el valor de la compra
                    setDinero(getDinero() - casilla.getPropiedad().getPrecio());
                    //se setea el valor del capital total
                    setCapitalTotal(getCapitalTotal() + casilla.getPropiedad().getPrecioVenta());
                    setContador(getContador() + 1);
                    getPropiedades().add(casilla.getPropiedad());
                    System.out.println(STR."El bot equilibrado compro la zona:\{casilla.getPropiedad().getZona()} de la provincia \{casilla.getPropiedad().getProvincia()}");

                } else if (getContador() == 2) {
                    //Se setea un propietario a la casilla
                    casilla.getPropiedad().setIdPropietrio(getIdJugador());
                    //se resta al dinero total el valor de la compra
                    setDinero(getDinero() - casilla.getPropiedad().getPrecio());
                    //se setea el valor del capital total
                    setCapitalTotal(getCapitalTotal() + casilla.getPropiedad().getPrecioVenta());
                    getPropiedades().add(casilla.getPropiedad());
                    System.out.println(STR."El bot equilibrado compro la zona:\{casilla.getPropiedad().getZona()} de la provincia \{casilla.getPropiedad().getProvincia()}");
                    setContador(0);
                }

                //se valida que la casilla sea del tipo ferrocarril
                else if (provincia.equals("ferrocarril")) {
                    //Se setea un propietario a la casilla
                    casilla.getPropiedad().setIdPropietrio(getIdJugador());
                    //se resta al dinero total el valor de la compra
                    setDinero(getDinero() - casilla.getPropiedad().getPrecio());
                    //se setea el valor del capital total
                    setCapitalTotal(getCapitalTotal() + casilla.getPropiedad().getPrecioVenta());
                    setContador(getContador() + 1);
                    getPropiedades().add(casilla.getPropiedad());
                    System.out.println(STR."El bot agresivo compro el ferrocarril: \{casilla.getPropiedad().getZona()}");
                }
            }
        }

    }

    //Construirá mejoras cuando el costo de la construcción no supere el 50% de su dinero en cuenta o
    // cuando se hayan vendido más del 75% de las propiedades.
    @Override
    public void construir(ArrayList<Propiedades>pTablero, ArrayList<Casilla> lista) {
        int vendidas = 0;
        for (Casilla c : lista) {
            if (c.getPropiedad() != null) {
                if (c.getPropiedad().getIdPropiedad() != 0) {
                    vendidas = vendidas + 1;

                }
            }
        }

        for (Propiedades prop:getPropiedades()){
            //21 respresenta el 75% del total de propiedades que se pueden vender (29)
            if (prop.getPrecioMejora() <= 0.5 * getDinero() || vendidas > 21) {

                if (validador.seTienenTodasZonas(pTablero,getPropiedades(),prop)&&prop.getCantidadChacras()<4){
                    prop.setCantidadChacras(prop.getCantidadChacras() + 1);

                    //Sacamos la suma de dinero de la cuenta
                    setDinero(getDinero() - prop.getPrecioMejora());

                    //Incrementamos el precio de venta de la propiedad
                    prop.setPrecioVenta(prop.getPrecioVenta() + (prop.getPrecioMejora() / 2));

                    //Aumentamos el valor del alquiler

                    int incremento = prop.getAlquiler() * (1 / prop.getCantidadChacras());
                    prop.setAlquiler(prop.getAlquiler() + incremento);

                    setCapitalTotal(getCapitalTotal() - prop.getPrecioMejora()/2);
                    System.out.println(STR."El jugador \{getNombre()} Mejoro \{prop.getProvincia()} \{prop.getZona()}");

                }

            }
        }



    }
}