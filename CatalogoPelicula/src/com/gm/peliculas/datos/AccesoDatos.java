package com.gm.peliculas.datos;

import com.gm.peliculas.domain.Pelicula;
import com.gm.peliculas.excepciones.AccesoDatosEx;
import com.gm.peliculas.excepciones.EscrituraDatosEx;
import com.gm.peliculas.excepciones.LecuraDatosEx;

import java.util.List;

public interface AccesoDatos {
    public abstract boolean existe(String nombreArchivo) throws AccesoDatosEx;
    public abstract List<Pelicula> listar(String nombreArchivo) throws LecuraDatosEx;
    public abstract void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    public abstract String buscar(String nombreArchivo, String buscar) throws LecuraDatosEx;
    public abstract void crear(String nombreArchivo) throws AccesoDatosEx;
    public abstract void borrar(String nombreArchivo) throws AccesoDatosEx;
}
