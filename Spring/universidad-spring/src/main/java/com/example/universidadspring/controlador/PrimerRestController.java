package com.example.universidadspring.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restapi")
public class PrimerRestController {
    @GetMapping
    public String holaMundo(){
        return "Hola Mundo! = D";
    }
}
