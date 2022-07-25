package com.ordenes.pc;

public class Raton extends DispositivoEntrada{
    private int idRaton;
    private static int contadorRatones;

    public void Raton(String tipoEntrada, String marca){
        idRaton=++contadorRatones;
        DispositivoEntrada(tipoEntrada,marca);

    }

    public String toString(){
        return "\tid: "+ idRaton + "\n\tContador de ratones: " + this.contadorRatones + "\n\tDetalles del dispositivo: [\n"+toString1()+"\n\t]";
    }
}
