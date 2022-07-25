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

    public int getIdMonitor() {
        return idMonitor;
    }

    public String getMarca() {
        return marca;
    }

    public int getTamanio() {
        return tamanio;
    }

    public static int getContadorMonitores() {
        return contadorMonitores;
    }

    public void setIdMonitor(int idMonitor) {
        this.idMonitor = idMonitor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public static void setContadorMonitores(int contadorMonitores) {
        Monitor.contadorMonitores = contadorMonitores;
    }
}
