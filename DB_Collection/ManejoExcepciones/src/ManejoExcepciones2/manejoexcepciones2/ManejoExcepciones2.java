package ManejoExcepciones2.manejoexcepciones2;

import ManejoExcepciones2.datos.AccesoDatos;
import ManejoExcepciones2.datos.ImplementacionMySql;
import ManejoExcepciones2.excepciones.AccesoDatosEx;
import ManejoExcepciones2.excepciones.LecturaDatosEx;

public class ManejoExcepciones2 {
    public static void main(String[] args) {

        AccesoDatos datos = new ImplementacionMySql();
        datos.simularError(true);
        ejecutar(datos, "listar");

        datos.simularError(true);
        System.out.println("");
        ejecutar(datos, "insertar");
    }

    private static void ejecutar(AccesoDatos datos, String accion) {
        if("listar".equals(accion)) {
            try {
                datos.listar();
            } catch (LecturaDatosEx ex) {
                System.out.println("Error lectura: Procesa la excepcion mas especifica de lectura de datos");
            } catch (AccesoDatosEx ex) {
                System.out.println("Error Acceso datos: Procesa la excepcion mas generica de acceso de datos");
            } catch (Exception ex) {
                System.out.println("Error general");
            }
            finally {
                System.out.println("Procesar finally es opcional, siempre se ejecutara sin importar si hubo error o no");
            }
        } else if("insertar".equals(accion)) {
            try {
                datos.insertar();
            } catch (AccesoDatosEx ex) {
                System.out.println("Error acceso datos: Podemos procesar solo la excepcion mas generica");
            }
            finally {
                System.out.println("Procesar finally es opcional, siempre se ejecutara sin importar si hubo error o no");
            }
        } else
            System.out.println("No se proporciona ninguna accion conocida");
    }
}
