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
@RequestMapping("/carreras")
public class CarreraController {
    private final CarreraDAO carreraDAO;
    @Autowired
    @Qualifier("alumnoDAOimpl")
    private PersonaDAO personaDAO;

    @Autowired
    public CarreraController(CarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }

    @GetMapping
    public List<Carrera> obtenerTodos(){
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();
        if(carreras.isEmpty()){
            throw new BadRequestException("No existen carreras");
        }
        return carreras;
    }

    @GetMapping("/{codigo}")
    public Carrera obtenerPorId(@PathVariable(value = "codigo", required = false)Integer id){
        Optional<Carrera> oCarrera = carreraDAO.findById(id);
        if(!oCarrera.isPresent()) {
            throw new BadRequestException(String.format("La carrera con id %d no existe",id));
        }
        return oCarrera.get();
    }

    @PostMapping
    public Carrera altaCarrera (@RequestBody Carrera carrera) {
        if(carrera.getCantidadAnios()<0){
            throw new BadRequestException("El campo cantidad de anios no puede ser negativo");
        }

        if(carrera.getCantidadMaterias()<0){
            throw new BadRequestException("El campo cantidad de materias no puede ser negativo");
        }
        return carreraDAO.save(carrera);
    }

    @PutMapping("/{id}")
    public Carrera actualizarCarrera(@PathVariable Integer id, @RequestBody Carrera carrera) {
        Carrera carreraUpdate = null;
        Optional<Carrera> oCarrera = carreraDAO.findById(id);
        if (!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe", id));
        }
        carreraUpdate = oCarrera.get();
        carreraUpdate.setNombre(carrera.getNombre());
        carreraUpdate.setCantidadAnios(carrera.getCantidadAnios());
        carreraUpdate.setCantidadMaterias(carrera.getCantidadMaterias());
        return carreraDAO.save(carreraUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable Integer id){
        carreraDAO.deleteById(id);
    }

}
