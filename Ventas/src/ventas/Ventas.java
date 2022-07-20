package ventas;

import com.gm.ventas.Orden;
import com.gm.ventas.Producto;

public class Ventas {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Leche", 5);
        Producto producto2 = new Producto("Soda", 2.5);
        Producto producto3 = new Producto("Carne", 2.5);
        Producto producto4 = new Producto("Spaghetti", 2.5);
        Producto producto5 = new Producto("Salsa", 2.5);
        Producto producto6 = new Producto("Queso", 2.5);
        Producto producto7 = new Producto("Masa", 2.5);
        Producto producto8 = new Producto("Huevos", 2.5);
        Producto producto9 = new Producto("Pan", 2.5);
        Producto producto10 = new Producto("Galletas", 2.5);
        Orden orden1 = new Orden();

        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        orden1.agregarProducto(producto3);
        orden1.agregarProducto(producto4);
        orden1.agregarProducto(producto5);
        orden1.agregarProducto(producto6);
        orden1.agregarProducto(producto7);
        orden1.agregarProducto(producto8);
        orden1.agregarProducto(producto9);
        orden1.agregarProducto(producto10);

        orden1.mostrarOrden();
    }
}
