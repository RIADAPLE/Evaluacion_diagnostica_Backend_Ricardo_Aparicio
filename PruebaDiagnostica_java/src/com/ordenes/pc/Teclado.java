package com.ordenes.pc;

public class Teclado extends DispositivoEntrada {
    private int idTeclado;
    private static int contadorTeclado;

    public void Teclado(String tipoEntrada, String marca){
        idTeclado=++contadorTeclado;
        DispositivoEntrada(tipoEntrada,marca);
    }

    public String toString(){
        return "\tid: "+idTeclado + "\n\tContador de teclados: " + contadorTeclado + "\n\tDetalles del dispositivo: [\n"+toString1()+"\n\t]";
    }
}
