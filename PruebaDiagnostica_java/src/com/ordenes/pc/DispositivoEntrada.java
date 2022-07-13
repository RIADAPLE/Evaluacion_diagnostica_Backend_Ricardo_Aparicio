package com.ordenes.pc;

public class DispositivoEntrada {
    private String tipoEntrada;
    private String marca;

    public void DispositivoEntrada(String tipoEntrada, String marca){
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    public String toString1(){
        return "\tTipo de entrada: "+this.tipoEntrada + "\n\tmarca: " + this.marca;
    }
}
