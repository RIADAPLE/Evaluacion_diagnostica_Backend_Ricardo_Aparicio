package com.spring.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.demo.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@GetMapping({"/index", "/","home"})
	public String index(Model model) {
		model.addAttribute("titulo", "hola Spring Framework");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Francisco");
		usuario.setApellido("Gonzalez");
		usuario.setEmail("FranGonz@gmail.com");
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Ricardo","Aparicio","hola@gmail.com"));
		usuarios.add(new Usuario("Andrea","Aparicio","hola@gmail.com"));
		usuarios.add(new Usuario("Jeannette","Lemus","hola@gmail.com"));
		model.addAttribute("titulo","listado de usuarios");
		model.addAttribute("usuarios",usuarios);
		return "listar";
	}
}
