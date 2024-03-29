package org.example.webapp.jaxws.models;


import jakarta.xml.bind.annotation.XmlRootElement;


//Para que salga en formato xml, se tiene que poner XmlRootElement, para json no es necesario
@XmlRootElement
public class Curso {
    private Long id;
    private String nombre;
    private String descripcion;
    private Instructor instructor;
    private Double duracion;
    public Curso() {
    }

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", instructor='" + instructor + '\'' +
                ", duracion=" + duracion +
                '}';
    }
}
