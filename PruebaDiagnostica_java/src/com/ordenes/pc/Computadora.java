package com.ordenes.pc;

public class Computadora {
    private int idComputadora;
    private static int contadorComputadora;
    private String nombre;
    private Monitor monitor;
    private Teclado teclado;
    private Raton raton;

    public Computadora(){

    }

    public void Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton){
        idComputadora = ++contadorComputadora;
        this.nombre = nombre ;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
    }

    public String toString(){
        return "Computadora:\nid: "+ idComputadora + "\nNombre: "+this.nombre+"\nMonitor[\n"+this.monitor.toString()+"]"+"\nTeclado[\n"+this.teclado.toString()+"\n]"+"\nRaton[\n"+this.raton.toString()+"\n]";
    }
}
