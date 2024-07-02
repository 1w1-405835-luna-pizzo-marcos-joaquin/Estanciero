package com.Grupo2.Estanciero.src.models;

import com.Grupo2.Estanciero.src.services.JugadorService;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Jugador {

    private Validadores validador=new Validadores();
    private Letras letras= new Letras();
    Scanner scanner=new Scanner(System.in);

    public Validadores getValidador() {
        return validador;
    }

    public void setValidador(Validadores validador) {
        this.validador = validador;
    }

    public Letras getLetras() {
        return letras;
    }

    public void setLetras(Letras letras) {
        this.letras = letras;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Player(String nom, int id, String tipo) {
        super(nom, id, tipo );
    }
    public Player() {
        super();
        setEsBot(false);
    }

    @Override
    public void comprar(Casilla casilla) {

        if (getDinero()>=casilla.getPropiedad().getPrecio())
        {
            if ( casilla.getPropiedad().getIdPropietrio() == 0) {

                //Se setea un propietario a la casilla
                casilla.getPropiedad().setIdPropietrio(getIdJugador());

                //se resta al dinero total el valor de la compra
                setDinero(getDinero() - casilla.getPropiedad().getPrecio());

                //se setea el valor del capital total
                setCapitalTotal(getCapitalTotal()+ casilla.getPropiedad().getPrecioVenta());

                //se agrega la casilla a la lista de casillas del jugador
                getPropiedades().add(casilla.getPropiedad());

                System.out.println(STR."Compraste la zona \{casilla.getPropiedad().getZona()} de la provincia \{casilla.getPropiedad().getProvincia()}");
            }
            else {
                System.out.println("No puedes comprar esta propiedad por que ya tiene un dueño.");
            }
        }
        else {
            System.out.println("El dinero no es suficiente para comprar esta propiedad.");
        }
    }

    @Override
    public void vender(Jugador  jugador) {
        boolean existeprop=false;
        do {

            letras.println("Quiere continuar en el menu de venta? (Y/n)");
            boolean respuesta = validador.getYesNoAnswer(scanner.nextLine());
            if (respuesta){
            letras.println("Ingrese el numero de la propiedad que quiere vender");
            letras.mostrarPropiedades(jugador.getPropiedades());
            int propiedadEliminada = validador.validadorNumero();
            existeprop=validador.validarExistaPropiedad(jugador.getPropiedades(),propiedadEliminada);

            if (existeprop){
                letras.println("Esta seguro de que quiere vender esta propiedad? (Y/n)");
                respuesta = validador.getYesNoAnswer(scanner.nextLine());
                if (respuesta) {

                    Propiedades p=new Propiedades();
                    for (Propiedades propiedad : jugador.getPropiedades()) {
                        if (propiedad.getNroCasilla() == propiedadEliminada) {
                            //Se elimina el propietario a la casilla
                            propiedad.setIdPropietrio(0);
                            //se suma al dinero total el valor de la venta
                            setDinero(getDinero() + propiedad.getPrecioVenta());
                            //se resta el valor del capital total
                            setCapitalTotal(getCapitalTotal() - propiedad.getPrecioVenta());

                             p=propiedad;
                            letras.println("Propiedad vendida");
                        }
                    }
                    jugador.getPropiedades().remove(p);
                }

            }
            else {
                letras.println("El numero de propiedad que usted ingreso no es correcto. Intente devuelta");
            }
        }
            else {break;}
        }while (!existeprop);
    }

    @Override
    public void alquilar(ArrayList<Jugador> lstJugadores,ArrayList<Casilla>lstCasilla){
        for (Casilla c:lstCasilla){
            if (c.getPropiedad()!=null&& c.getNum_casilla()==getCasilla().getNum_casilla()){
                if (c.getPropiedad().getIdPropietrio()!=getIdJugador()&&c.getPropiedad().getIdPropietrio()!=0){
                    for (Jugador j:lstJugadores){
                        if (c.getPropiedad().getIdPropietrio()==j.getIdJugador()){
                            int alquiler=c.getPropiedad().getAlquiler();
                            //verificar que se pueda pagar el alquiler
                            if (alquiler<=getDinero()) {
                                //sumarle el precio del alquiler al propietario
                                j.setDinero(j.getDinero() + alquiler);
                                j.setCapitalTotal(j.getCapitalTotal() + alquiler);
                                //restarle el precio del alquiler al jugador
                                setDinero(getDinero() - alquiler);
                                System.out.println(STR."Le Pagaste $\{alquiler} a \{j.getNombre()} por alquiler");
                            }
                            else {
                                pagar(alquiler);
                                //sumarle el precio de lo que le alcanzo para pagar al propietario
                                j.setDinero(j.getDinero()+ getDinero());
                                j.setCapitalTotal(j.getCapitalTotal()+getDinero());
                                System.out.println(STR."Le pagaste $\{getDinero()} a \{j.getNombre()} por alquiler y te fuiste a la quiebra");
                                //Se le deja la cuenta en 0
                                setDinero(0);
                                setCapitalTotal(0);
                            }
                        }
                    }
                }
            }
        }


    }
    @Override
    public void pagar(int monto){
        //ver si no se tiene dinero suficiente
        if (monto>getDinero()){
            //ver que se tengan propiedades para vender
            if (!getPropiedades().isEmpty()){
                do {
                    System.out.println("No tienes el dinero suficiente para pagar, deberas vender una propiedad");
                    vender();
                }while (monto>getDinero());
            }
            else {//si no se tienen pierde y finaliza el juego
                System.out.println("No tienes dinero para pagar el alquiler, ni propiedades que puedas vender, has perdido. :(");
                setPerdio(true);
            }
        }
    }
    @Override
    public void irPreso() {
        //si va preso
        getCasilla().setNum_casilla(14);
        setPreso(true);
        setTurnosPreso(3);
      letras.irPreso();
    }

    @Override
    public ArrayList<Integer> mover() {
        setDados(tirarDdo());
        Integer dado1 = getDados().get(0);
        Integer dado2 = getDados().get(1);

        letras.dibujarDado(getDados());
        //se fija si estas preso y si lo estas y sacas dados iguales salis
        if (getTurnosPreso() > 0 && dado1 == dado2)
        {
            System.out.println("Sacaste dados iguales, sales de la carcel");
            setTurnosPreso(0);
            setPreso(false);
        }
        else if (getTurnosPreso() > 0 ) {

            System.out.println("Sigues preso");
            setTurnosPreso(getTurnosPreso()-1);
            if (getTurnosPreso()<1){
                System.out.println("sales de la carcel en la proxima ronda");
                setPreso(false);
            }
            return getDados();
        }

        setNumeroDado(dado1 + dado2);
        System.out.println(STR."sacaste los dados \{dado1} \{dado2}");
        Integer numCasilla= getCasilla().getNum_casilla() + getNumeroDado();


        if (numCasilla>41){
            numCasilla=numCasilla-42;
            getCasilla().setNum_casilla(numCasilla);
            System.out.println("Pasaste por la salida, cobras $5.000!");

            setDinero(getDinero()+5000);
            setCapitalTotal(getCapitalTotal()+5000);
        }
        switch (numCasilla){
            case 35: System.out.println("Ops, esta casilla te envia a la carcel");
                irPreso();
                break;
            case 7:
                System.out.println("Premio ganadero, cobre $2.500");
                setDinero(getDinero()+2500);
                setCapitalTotal(getCapitalTotal()+2500);
                break;
            case 28:
                System.out.println("Estas en una casilla de descanso");
                break;
            case 21:
                System.out.println("Estas en una casilla de descanso");
                break;
            case 4:      System.out.println("Por caer en esta casilla pagas impuestos");
                pagar(5000);
                if (getDinero()>=5000){
                    setDinero(getDinero()-5000);
                    setCapitalTotal(getCapitalTotal()-5000);
                }
                break;
            case 41:     System.out.println("Por caer en esta casilla pagas impuestos");
                pagar(2000);
                if (getDinero()>=2000){
                    setDinero(getDinero()-2000);
                    setCapitalTotal(getCapitalTotal()-2000);
                }
                break;  }

        getCasilla().setNum_casilla(numCasilla);


        return getDados();
    }
    public boolean volverATirar(ArrayList<Integer>dados){
        if (!isPreso()){
            Integer dado1 = dados.get(0);
            Integer dado2 = dados.get(1);
            if (dado1 == dado2) {
                if  (getNumTiros() == 3){
                    irPreso();
                    setNumTiros(1);
                    return false;
                }
                else {
                    setNumTiros(getNumTiros()+1);
                    System.out.println(STR." Vuelves a tirar el dado, estas a \{3 - getNumTiros()} tiros de ir a la carcel.");
                    return true;}

            }
            else setNumTiros(1);
        }
        return false;
    }
    @Override
    public void sacarTarjeta(ArrayList<Card>lstSuerte,ArrayList<Card>lstDestino) {

        int nroCasilla = getCasilla().getNum_casilla();
        Card tarjeta = null;
        boolean destino = false;

        //obtener la primer tarjeta de la lista suerte o destino segun corresponda
        if (nroCasilla == 15 || nroCasilla == 36) {
            tarjeta = lstSuerte.removeFirst();
            System.out.println("OBTUVISTE UNA TARJETA SUERTE");
        } else if (nroCasilla == 10 || nroCasilla == 25 || nroCasilla == 38) {
            tarjeta = lstDestino.removeFirst();
            destino = true;
            System.out.println("OBTUVISTE UNA TARJETA DESTINO");
        }


        if (tarjeta != null) {
            System.out.println(tarjeta.getDescripcion());
            switch (tarjeta.getAccion()) {
                //validar que se pase por la salida al ir a la tarjeta indicada
                case "mover":
                    if ( getCasilla().getNum_casilla() > tarjeta.getValor()) {
                        getCasilla().setNum_casilla(tarjeta.getValor());
                        setDinero(getDinero() + 5000);
                        setCapitalTotal(getCapitalTotal() + 5000);
                        System.out.println("Pasaste por la salida, cobra $5.000");
                    } else {
                        getCasilla().setNum_casilla(tarjeta.getValor());
                    }
                    break;

                    //recibir el dinero que indica la tarjeta
                case "suma":
                    setDinero(getDinero() + tarjeta.getValor());
                    setCapitalTotal(getCapitalTotal() + tarjeta.getValor());
                    break;

                    //perder dinero que indica la tarjeta
                case "resta":
                    pagar(tarjeta.getValor());
                    setDinero(getDinero() - tarjeta.getValor());
                    setCapitalTotal(getCapitalTotal() - tarjeta.getValor());
                    break;

                    //retroceder lo que indique la tarjeta
                case "retrocede":
                    getCasilla().setNum_casilla(getCasilla().getNum_casilla() - tarjeta.getValor());
                    break;

                case "carcel":
                    irPreso();
                    break;
            }

            //volver a agregar la tarjeta al final de la lista
            if (destino) {
                lstDestino.add(tarjeta);
            } else {
                lstSuerte.add(tarjeta);
            }
        }
    }


    @Override
    public Boolean construir(ArrayList<Propiedades>pTablero,Jugador jugador){
        boolean existeProp=false;
        int cantidadProvinciasIguales=0;
        do {
            letras.println("Quiere continuar en el menu de construccion? (Y/n)");
            boolean respuesta = validador.getYesNoAnswer(scanner.nextLine());
            if (respuesta) {
                letras.println("Ingrese el numero de la propiedad en la que quiere construir");
                letras.mostrarPropiedades(jugador.getPropiedades());
                int propiedadConstruir = validador.validadorNumero();
                existeProp = validador.validarExistaPropiedad(jugador.getPropiedades(), propiedadConstruir);
                if (existeProp) {

                    letras.println("Esta seguro de que quiere construir en esta propiedad? (Y/n)");
                    respuesta = validador.getYesNoAnswer(scanner.nextLine());
                    if (respuesta) {

                        for (Propiedades propiedad :jugador.getPropiedades()) {
                            if (propiedad.getNroCasilla() == propiedadConstruir) {
                               if (validador.seTienenTodasZonas(pTablero,jugador.getPropiedades(),propiedad)){
                                   if ( getDinero() >= propiedad.getPrecioMejora() && propiedad.getCantidadChacras() < 4) {

                                       propiedad.setCantidadChacras(propiedad.getCantidadChacras() + 1);

                                       //Sacamos la suma de dinero de la cuenta
                                       setDinero(getDinero() - propiedad.getPrecioMejora());

                                       setCapitalTotal(getCapitalTotal() - propiedad.getPrecioMejora() / 2);

                                       System.out.println("Construccion exitosa");
                                       return true;

                                   }
                               }
                                else {
                                   System.out.println("no se puede construir por que no se tienen todas las zonas de esta provincia");
                               }
                            }
                        }
                    }
                } else {
                    letras.println("El numero de propiedad que usted ingreso no es correcto. Intente devuelta");
                }
            }
            else {break;}
        }while (!existeProp);

        return false;

    }

}






