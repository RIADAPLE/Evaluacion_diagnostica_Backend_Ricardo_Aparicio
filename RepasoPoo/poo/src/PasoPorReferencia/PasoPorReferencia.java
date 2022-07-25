package PasoPorReferencia;

public class PasoPorReferencia {
    public static void main(String[] args) {
        Persona_referencia p = new Persona_referencia();
        p.cambiarNombre("Juan");
        imprimirNombre(p);
        modificarPersona(p);
        imprimirNombre(p);
    }

    public static void modificarPersona(Persona_referencia arg){
        arg.cambiarNombre("Carlos");
    }

    public static void imprimirNombre(Persona_referencia p){
        System.out.println("Valor Recibido:" + p.obtenerNombre());
    }
}
