package com.example.universidadspring.controlador;

import com.example.universidadspring.exception.BadRequestException;
import com.example.universidadspring.modelo.entidades.Alumno;
import com.example.universidadspring.modelo.entidades.Carrera;
import com.example.universidadspring.modelo.entidades.Persona;
import com.example.universidadspring.servicios.contratos.CarreraDAO;
import com.example.universidadspring.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    private final PersonaDAO alumnoDAO;
    private final CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOimpl") PersonaDAO alumnoDAO, CarreraDAO carreraDAO) {
        this.alumnoDAO = alumnoDAO;
        this.carreraDAO = carreraDAO;
    }

    @GetMapping
    public List<Persona> obtenerTodos(){
        List<Persona> alumnos = (List<Persona>) alumnoDAO.findAll();
        if(alumnos.isEmpty()){
            throw new BadRequestException("No existen alumnos");
        }
        return alumnos;
    }

    @GetMapping("/{id}")
    public Persona obtenerAlumnosPorId(@PathVariable(required = false)Integer id){
        Optional<Persona> oAlumno = alumnoDAO.findById(id);
        if(!oAlumno.isPresent()){
            throw new BadRequestException(String.format("Alumno con id %d no existe",id));
        }
        return oAlumno.get();
    }

    @PostMapping
    public Persona altaAlumno(@RequestBody Persona alumno){
        return alumnoDAO.save(alumno);
    }

    @PutMapping("/{id}")
    public Persona actualizarAlumno(@PathVariable Integer id, @RequestBody Persona alumno) {
        Persona alumnoUpdate = null;
        Optional<Persona> oAlumno = alumnoDAO.findById(id);
        if (!oAlumno.isPresent()){
            throw new BadRequestException(String.format("El alumno con id %d no existe", id));
        }
        alumnoUpdate = oAlumno.get();
        alumnoUpdate.setNombre(alumno.getNombre());
        alumnoUpdate.setApellido(alumno.getApellido());
        alumnoUpdate.setDireccion(alumno.getDireccion());
        return alumnoDAO.save(alumnoUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id){
        alumnoDAO.deleteById(id);
    }

    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona asignarCarreraAlAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Optional<Persona> oAlumno = alumnoDAO.findById(idAlumno);
        if (!oAlumno.isPresent()){
            throw new BadRequestException(String.format("El alumno con id %d no existe", idAlumno));
        }
        Optional<Carrera> oCarrera = carreraDAO.findById(idCarrera);
        if (!oAlumno.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe", idCarrera));
        }
        Persona alumno = oAlumno.get();
        Carrera carrera = oCarrera.get();

        ((Alumno)alumno).setCarrera(carrera);

        return alumnoDAO.save(alumno);
    }
}
