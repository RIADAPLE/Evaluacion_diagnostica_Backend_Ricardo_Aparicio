package ManejoExcepciones1.manejoexcepciones1;

import ManejoExcepciones1.domain.Division;
import ManejoExcepciones1.domain.OperationException;

public class ManejoExcepcionesArg {
    public static void main(String[] args) throws OperationException {
        try {
            int op1 = Integer.parseInt(args[0]);
            int op2 = Integer.parseInt(args[1]);
            Division div = new Division(op1, op2);
            div.visualizarOperacion();
        } catch (ArrayIndexOutOfBoundsException aie){
            System.out.println("Ocurrió una excepciíon: ");
            System.out.println("Hubo un error al acceder un elemento fuera de rango");
            aie.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.out.println("Ocurrió una excepción: ");
            System.out.println("Uno de los argumentos no es entero");
            nfe.printStackTrace();
        } catch (OperationException oe) {
            System.out.println("Ocurrió una excepción: ");
            System.out.println("Se trató de realizar una operación erronea");
            oe.printStackTrace();
        } finally {
            System.out.println("Se terminaron de revisar las excepciones");
        }
    }
}
