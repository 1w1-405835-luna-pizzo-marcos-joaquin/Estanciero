package com.Grupo2.Estanciero.src.models;

import com.Grupo2.Estanciero.src.services.JugadorService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class Jugador implements JugadorService {

    private int id;
    private String nombre;
    private int dinero;
    private ArrayList<Propiedades> propiedades;
    private Casilla casilla;
    private int capitalTotal;
    private boolean preso;
    private boolean perdio;
    private int turnosPreso;
    private boolean gano;
    private Integer numeroDado;
    private  Integer turno;
    private ArrayList<Integer>dados;
    private  boolean esBot;
    private int numTiros;

    @Getter
    @Setter
    private String tipo;

    @Getter
    @Setter
    private int casillaActual;

    public int getNumTiros() {
        return numTiros;
    }

    public void setNumTiros(int numTiros) {
        this.numTiros = numTiros;
    }

    public boolean getEsBot() {
        return esBot;
    }

    public void setEsBot(boolean esBot) {
        this.esBot = esBot;
    }

    public ArrayList<Integer> getDados() {
        return dados;
    }

    public void setDados(ArrayList<Integer> dados) {
        this.dados = dados;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public Integer getNumeroDado() {
        return numeroDado;
    }

    public void setNumeroDado(Integer numeroDado) {
        this.numeroDado = numeroDado;
    }

    public boolean getGano() {return gano; }

    public void setGano(boolean gano) {this.gano = gano;}

    public boolean getPerdio() {return perdio;}

    public void setPerdio(boolean perdio) { this.perdio = perdio;}

    public int getIdJugador() {
        return id;
    }

    public void setIdJugador(int idJugador) {
        this.id = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public ArrayList<Propiedades> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(ArrayList<Propiedades> propiedades) {
        this.propiedades = propiedades;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public int getCapitalTotal() {
        return capitalTotal;
    }

    public void setCapitalTotal(int capitalTotal) {
        this.capitalTotal = capitalTotal;
    }

    public boolean isPreso() {
        return preso;
    }

    public void setPreso(boolean preso) {
        this.preso = preso;
    }

    public int getTurnosPreso() {
        return turnosPreso;
    }

    public void setTurnosPreso(int turnosPreso) {
        this.turnosPreso = turnosPreso;
    }


    public Jugador() {

        this.nombre = "";
        dinero=35000;
        propiedades=new ArrayList<>();
        casilla=new Casilla();
        capitalTotal=35000;
        preso=false;
        turnosPreso=0;
        perdio=false;
        numeroDado=0;
        dados=new ArrayList<>();
        esBot=true;
        numTiros=1;
        casillaActual = 0;
    }
    public Jugador(String nom, int id, String tipo){
        this.nombre = nom;
        this.id = id;
        this.tipo = tipo;
        dinero=35000;
        propiedades=new ArrayList<>();
        casilla=new Casilla();
        capitalTotal=35000;
        preso=false;
        turnosPreso=0;
        perdio=false;
        numeroDado=0;
        dados=new ArrayList<>();
        numTiros=1;
        casillaActual = 0;
    }

    @Override
    public ArrayList<Integer> tirarDdo() {
        int nro1;
        int nro2;
        ArrayList<Integer>numeros=new ArrayList<>();
        Random random=new Random();
        nro1=random.nextInt(6)+1;
        nro2=random.nextInt(6)+1;
        numeros.add(nro1);
        numeros.add(nro2);
        return numeros;
    }

    /**
     * completar
     *
     * @return
     */
    @Override
    public ArrayList<Integer> mover() {
        setDados(tirarDdo());
        Integer dado1 = getDados().get(0);
        Integer dado2 = getDados().get(1);

        //se fija si estas preso y si lo estas y sacas dados iguales salis
        if (getTurnosPreso() > 0 && dado1 == dado2)
        {
            System.out.println(getNombre()+" Saco dados iguales, sale de la carcel");
            setTurnosPreso(0);
            setPreso(false);
        }
        else if (getTurnosPreso() > 0 ) {

            System.out.println(getNombre()+" Sigue preso");
            setTurnosPreso(getTurnosPreso()-1);
            if (getTurnosPreso()<1){
                System.out.println(getNombre()+" sale de la carcel en la proxima ronda");
                setPreso(false);
            }
            return getDados();
        }

        setNumeroDado(dado1 + dado2);
        System.out.println(STR."\{getNombre()} saco \{dado1} \{dado2}");
        Integer numCasilla= getCasilla().getNum_casilla() + getNumeroDado();


        if (numCasilla>41){
            numCasilla=numCasilla-42;
            getCasilla().setNum_casilla(numCasilla);
            System.out.println(getNombre()+" Paso por la salida, cobro $5.000!");
            setDinero(getDinero()+5000);
            setCapitalTotal(getCapitalTotal()+5000);
        }
        switch (numCasilla){
            case 35: System.out.println(STR."Se envio a \{getNombre()} a la carcel");
                irPreso();
                break;
            case 7:
                System.out.println(STR."Premio ganadero, \{getNombre()} cobro $2.500");
                setDinero(getDinero()+2500);
                setCapitalTotal(getCapitalTotal()+2500);
                break;
            case 28:
                System.out.println(STR."\{getNombre()}Esta en una casilla de descanso");
                break;
            case 21:
                System.out.println(STR."\{getNombre()}Esta en una casilla de descanso");
                break;
            case 4:    System.out.println(STR."\{getNombre()}Pago impuestos");
                pagar(5000);
                if (getDinero()>=5000){
                    setDinero(getDinero()-5000);
                    setCapitalTotal(getCapitalTotal()-5000);
                }
                else {
                    System.out.println(getNombre()+" Se fue a la quiebra");}
                break;
            case 41:     System.out.println(STR."\{getNombre()}Pago impuestos");
                pagar(2000);
                if (getDinero()>=2000){
                    setDinero(getDinero()-2000);
                    setCapitalTotal(getCapitalTotal()-2000);
                }
                else {
                    System.out.println(getNombre()+" Se fue a la quiebra");}
                break;
        }

        getCasilla().setNum_casilla(numCasilla);
        System.out.println(STR."\{getNombre()} avanzo a la casilla \{getCasilla().getNum_casilla()}");

        return getDados();
    }

    @Override
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
                    System.out.println(STR."\{getNombre()} Vuelve a tirar el dado, esta a \{3 - getNumTiros()} tiros de ir a la carcel.");
                    return true;}

            }
            else setNumTiros(1);
        }
        return false;
    }

    @Override
    public void comprar(Casilla casilla) {
        System.out.println("hola mundo");
    }

    @Override
    public void vender() {
        Propiedades p= getPropiedades().getFirst();
        setDinero(getDinero()+p.getPrecioVenta());
        setCapitalTotal(getCapitalTotal()+p.getPrecioVenta());
        getPropiedades().remove(p);
    }

    @Override
    public void vender(Jugador jugador){}

    @Override
    public void construir(ArrayList<Propiedades>pTablero) {}

    @Override
    public void construir(ArrayList<Propiedades>pTablero, ArrayList<Casilla> lista){}

    @Override
    public Boolean construir(ArrayList<Propiedades>pTablero, Jugador jugador){return null;}

    @Override
    public void sacarTarjeta(ArrayList<Card>lstSuerte,ArrayList<Card>lstDestino) {
        int nroCasilla= getCasilla().getNum_casilla();
        Card tarjeta=null;
        boolean destino=false;
        //obtener la primer tarjeta de la lista suerte o destino segun corresponda
        if (nroCasilla==15||nroCasilla==36) {
            tarjeta = lstSuerte.removeFirst();
            System.out.println(getNombre()+" saco una tarjeta suerte");
        }
        else if (nroCasilla == 10 || nroCasilla == 25 || nroCasilla == 38){
            tarjeta=lstDestino.removeFirst();
            destino=true;
            System.out.println(getNombre()+" saco una tarjeta destino");}

        if (tarjeta!=null){
            System.out.println("''"+tarjeta.getDescripcion()+"''");

            switch (tarjeta.getAccion()){
                //validar que se pase por la salida al ir a la tarjeta indicada
                case "mover":if ( getCasilla().getNum_casilla()>tarjeta.getValor()){
                    getCasilla().setNum_casilla(tarjeta.getValor());
                    setDinero(getDinero()+5000);
                    setCapitalTotal(getCapitalTotal()+5000);
                    System.out.println("Paso por la salida, cobra $5.000");
                }
                else { getCasilla().setNum_casilla(tarjeta.getValor());}
                    break;
                //recibir el dinero que indica la tarjeta
                case "suma": setDinero(getDinero()+tarjeta.getValor());
                    setCapitalTotal(getCapitalTotal()+tarjeta.getValor());
                    break;
                //perder dinero que indica la tarjeta
                case "resta":
                    pagar(tarjeta.getValor());
                    setDinero(getDinero()-tarjeta.getValor());
                    setCapitalTotal(getCapitalTotal()-tarjeta.getValor());
                    break;
                //retroceder lo que indique la tarjeta
                case "retrocede": getCasilla().setNum_casilla(getCasilla().getNum_casilla()- tarjeta.getValor());
                    break;
                case "carcel": irPreso();
                    break;
            }
        }


        //volver a agregar la tarjeta al final de la lista
        if (destino){lstDestino.add(tarjeta);}
        else {lstSuerte.add(tarjeta);}
    }

    @Override
    public void irPreso() {
        //si va preso
        casilla.setNum_casilla(14);
        preso=true;
        turnosPreso=3;
    }

    @Override
    public void alquilar(ArrayList<Jugador>lstJugadores,ArrayList<Casilla>lstCasilla){

        for (Casilla c:lstCasilla){
            if (c.getNum_casilla()==getCasilla().getNum_casilla()&&c.getPropiedad()!=null){
                if (c.getPropiedad().getIdPropietrio()!=getIdJugador()&&c.getPropiedad().getIdPropietrio()!=0){
                    for (Jugador j:lstJugadores){
                        if (c.getPropiedad().getIdPropietrio()==j.getIdJugador()){
                            int alquiler=c.getPropiedad().getAlquiler();

                            //Rama de cuando le alcanza para pagar el alquiler completo

                            if(alquiler <= getDinero())
                            {
                                //sumarle el precio del alquiler al propietario
                                j.setDinero(j.getDinero()+ alquiler);
                                j.setCapitalTotal(j.getCapitalTotal()+alquiler);
                                //restarle el precio del alquiler al jugador
                                setDinero(getDinero()-alquiler);
                                setCapitalTotal(getCapitalTotal()-alquiler);
                                System.out.println(STR."El jugador \{getNombre()} le pago $\{alquiler} a \{j.getNombre()} por alquiler");
                            }

                            //Rama de cuando no le alcanza para pagar el alquiler completo
                            else
                            {
                                pagar(alquiler);
                                //sumarle el precio de lo que le alcanzo para pagar al propietario
                                j.setDinero(j.getDinero()+ getDinero());
                                j.setCapitalTotal(j.getCapitalTotal()+getDinero());
                                System.out.println(STR."El jugador \{getNombre()} le pago $\{getDinero()} a \{j.getNombre()} por alquiler y se fue a la quiebra");
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

    public void pagar(int monto){
        //ver si no se tiene dinero suficiente
        if (monto>getDinero()){
            //ver que se tengan propiedades para vender
            if (!getPropiedades().isEmpty()){
                do {
                    System.out.println(getNombre()+" no tiene el dinero suficiente para pagar, debera vender una propiedad");
                    vender();
                }while (monto>getDinero());
            }
            else {//si no se tienen pierde y finaliza el juego
                System.out.println(getNombre()+" no tiene dinero para pagar, ni propiedades que pueda vender, ha perdido. :(");
                setPerdio(true);
            }
        }
    }
}