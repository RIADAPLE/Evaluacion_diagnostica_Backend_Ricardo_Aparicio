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

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
