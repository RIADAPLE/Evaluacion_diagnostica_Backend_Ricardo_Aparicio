package PasoPorReferencia;

public class Persona_referencia {
    String nombre;

    public void cambiarNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public String obtenerNombre(){
        return nombre;
    }
}
