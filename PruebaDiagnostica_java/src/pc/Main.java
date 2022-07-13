package pc;

import com.ordenes.pc.*;

public class Main {
    public static void main(String[] args) {
        Computadora computadora1 = new Computadora();
        Monitor monitor1 = new Monitor();
        Teclado teclado1 = new Teclado();
        Raton raton1 = new Raton();

        monitor1.Monitor("Acer",22);
        teclado1.Teclado("Teclado","MSI");
        raton1.Raton("Raton","Logitech");
        computadora1.Computadora("HP",monitor1,teclado1,raton1);

        Computadora computadora2 = new Computadora();
        Monitor monitor2 = new Monitor();
        Teclado teclado2 = new Teclado();
        Raton raton2 = new Raton();

        monitor2.Monitor("HP",24);
        teclado2.Teclado("Teclado","Razer");
        raton2.Raton("Raton","Hyper x");
        computadora2.Computadora("DELL",monitor2,teclado2,raton2);

        Computadora computadora3 = new Computadora();
        Monitor monitor3 = new Monitor();
        Teclado teclado3 = new Teclado();
        Raton raton3 = new Raton();

        monitor3.Monitor("MSI",24);
        teclado3.Teclado("Teclado","Dragon red");
        raton3.Raton("Raton","Xtech");
        computadora3.Computadora("Clon",monitor3,teclado3,raton3);

        //computadora1.toString();
        Orden orden1 = new Orden(3);

        orden1.agregarComputadora(computadora1);
        orden1.agregarComputadora(computadora2);
        orden1.agregarComputadora(computadora3);
        orden1.agregarComputadora(computadora1);
        Orden orden2 = new Orden(3);
        orden2.agregarComputadora(computadora3);
        orden1.mostrarOrden();
        orden2.mostrarOrden();
    }
}