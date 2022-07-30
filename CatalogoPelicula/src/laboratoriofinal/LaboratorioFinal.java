package laboratoriofinal;

import com.gm.peliculas.negocio.CatalogoPeliculas;
import com.gm.peliculas.negocio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class LaboratorioFinal {
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "c:\\catalogoPeliculas\\peliculas.txt";
    private static final CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();

    public static void main(String[] args) {
        do{
            Menu();
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    catalogoPeliculas.iniciarArchivo(nombreArchivo);
                    break;
                case 2:
                    System.out.println("Escriba el nombre de la pelicula que desea insertar");
                    String nombrePeli = scanner.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePeli, nombreArchivo);
                    break;
                case 3:
                    catalogoPeliculas.listarPeliculas(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Escriba el nombre de la pelicula que desea buscar");
                    String buscarPeli = scanner.nextLine();
                    catalogoPeliculas.buscarPelicula(buscarPeli, nombreArchivo);
                    break;
                case 0:
                    System.out.println("Se finalizo el programa correctamente");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 0);
    }

    public static void Menu(){
        System.out.println("Que desea hacer?\n1. Iniciar Archivo\n2. Agregar Pelicula\n3. Listar Pelicula\n4. Buscar Pelicula\n0. Salir\n");
    }
}
