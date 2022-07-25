package com.ordenes.pc;

public class Computadora {
    private int idComputadora;
    private static int contadorComputadora;
    private String nombre;
    private Monitor monitor;
    private Teclado teclado;
    private Raton raton;
    private double precio;

    public Computadora(){

    }

    public void Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton, double precio){
        idComputadora = ++contadorComputadora;
        this.nombre = nombre ;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
        this.precio = precio;
    }

    public String toString(){
        return "Computadora:\nid: "+ idComputadora + "\nNombre: "+ nombre + "\nPrecio: $" + precio + "\nMonitor[\n"+this.monitor.toString()+"\n]"+"\nTeclado[\n"+this.teclado.toString()+"\n]"+"\nRaton[\n"+this.raton.toString()+"\n]";
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public static int getContadorComputadora() {
        return contadorComputadora;
    }

    public String getNombre() {
        return nombre;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public Raton getRaton() {
        return raton;
    }

    public double getPrecio() {
        return precio;
    }

    public void setIdComputadora(int idComputadora) {
        this.idComputadora = idComputadora;
    }

    public static void setContadorComputadora(int contadorComputadora) {
        Computadora.contadorComputadora = contadorComputadora;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public void setRaton(Raton raton) {
        this.raton = raton;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
