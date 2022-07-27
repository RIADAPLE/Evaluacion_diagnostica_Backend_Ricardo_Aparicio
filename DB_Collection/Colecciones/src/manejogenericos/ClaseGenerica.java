package manejogenericos;

public class ClaseGenerica<T> {

    T objeto;

    public ClaseGenerica(T objeto){
        this.objeto = objeto;
    }

    void obtenerTipo(){
        System.out.println("El tipo T es: " + objeto.getClass().getName());
    }
}
