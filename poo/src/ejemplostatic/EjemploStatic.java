package ejemplostatic;

public class EjemploStatic {
    public static void main(String[] args) {
        Personota p1 = new Personota("Juan");
        System.out.println("Persona1: " + p1);

        Personota p2 = new Personota("karla");
        System.out.println("Persona2: " + p2);

        System.out.println("No. Personas:" + Personota.getContadorPersonas());
    }
}
