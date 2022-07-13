package com.ordenes.pc;

public class Monitor {
    private int idMonitor;
    private String marca;
    private int tamanio;
    private static int contadorMonitores;

    public Monitor(){

    }

    public void Monitor(String marca, int tamanio){
        idMonitor = ++contadorMonitores;
        this.marca = marca ;
        this.tamanio = tamanio;

    }

    public String toString(){
        return "\tid: "+idMonitor+ "\n\tmarca: "+this.marca+"\n\ttamanio: "+this.tamanio+"\n\tcontador de monitores: "+this.contadorMonitores;
    }
}
