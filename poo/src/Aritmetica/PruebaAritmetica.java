package Aritmetica;

public class PruebaAritmetica {
    public static void main(String[] args) {

        int operandoA = 6;
        int operandoB = 2;

        Aritmetica obj1 = new Aritmetica(operandoA,operandoB);

        System.out.println("Operando A: "+ operandoA + " y Operando B: " + operandoB);

        System.out.println("\nResultado suma: " + obj1.sumar());

        System.out.println("\nResultado resta: " + obj1.restar());

        System.out.println("\nResultado multipliacion: " + obj1.multiplicar());

        System.out.println("\nResultado division: " + obj1.dividir());
    }

    /*
    void otrometodo(){
        System.out.println("Operando A: "+ operandoA);
    }
     */
}
