package ejemplostatic;

public class Personota {
    private String nombre;
    private int idPersona;
    private static int contadorPersonas;

    public Personota(String nombre){
        contadorPersonas++;
        idPersona = contadorPersonas;
        this.nombre = nombre;
    }

    public String toString() {
        return "Personota[" +
                " idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ']';
    }

    public static int getContadorPersonas(){
        return contadorPersonas;
    }
}
