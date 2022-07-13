package com.ordenes.pc;

import java.util.ArrayList;

public class Orden {
    private int idOrden;
    private ArrayList<Computadora> computadoras = new ArrayList<>();
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private int maxComputadoras;

    public Orden(int maxComputadoras){
        idOrden = ++contadorOrdenes;
        contadorComputadoras = 0;
        this.maxComputadoras = maxComputadoras;
    }

    public void agregarComputadora(Computadora computadora){

        if(contadorComputadoras>=this.maxComputadoras){
            System.out.println("No se puede agregar mas computadoras");
        }
        else{
            contadorComputadoras++;
            computadoras.add(computadora);
            System.out.println("Se agrego la computadora con exito");
        }
    }

    public double calcularTotal(){
        return (long) computadoras.size();
    }

    public void mostrarOrden(){
        System.out.println("\nOrden " + idOrden + "\nContador de ordenes: " + contadorOrdenes + "\nTotal de computadoras: "+ calcularTotal() + "\nMaximo de computadoras: "+maxComputadoras);
        for (int i = 0; i < computadoras.size(); i++) {
            System.out.println(computadoras.get(i));
        }
    }
}
