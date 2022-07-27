package ManejoExcepciones1.manejoexcepciones1;

import ManejoExcepciones1.domain.Division;
import ManejoExcepciones1.domain.OperationException;

public class ManejoExcepciones1 {
    public static void main(String[] args) {
        try {
            Division division = new Division(10,0);
            division.visualizarOperacion();
        } catch (OperationException oe){
            System.out.println("Ocurrió un error!!!");
            oe.printStackTrace();
        }
    }
}
