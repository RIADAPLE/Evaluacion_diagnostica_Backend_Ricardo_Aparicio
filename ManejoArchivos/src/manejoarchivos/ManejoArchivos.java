package manejoarchivos;

import utileria.*;

import static utileria.Archivos.*;

public class ManejoArchivos {

    private static final String NOMBRE_ARCHIVO = "c:\\pruebaJava\\pruebaJava.txt";

    public static void main(String[] args) {
        //Crear un archivo
        crearArchivo(NOMBRE_ARCHIVO);
        //Escribir a un archivo
        escribirArchivo(NOMBRE_ARCHIVO);
        //Leer un archivo
        leerArchivo(NOMBRE_ARCHIVO);
        //Anexar informacion a un archivo
        anexarArchivo(NOMBRE_ARCHIVO);
        //Leer un archivo
        leerArchivo(NOMBRE_ARCHIVO);
    }
}
