
package com.example.encuentroSpring.demo.controller;


import com.example.encuentroSpring.demo.entities.Persona;
import com.example.encuentroSpring.demo.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



//Sera el encargado de comunicarse con el servicio
@Controller
@RequestMapping("/")
public class PersonaController {
    
    
    @Autowired
    private PersonaService personaService;
    //Inyectamos la implementacion personaService
    
    @GetMapping
    //Usar metodos HTTP
    //Clase model se usa para pasar objetos del controller a la vista
    public String listarPersonas(Model model){
    
        List<Persona> personas = personaService.obtenerTodas();
        //Trafiera datos del controllardor a la vista
        model.addAttribute("Listapersona", personas);
        
        return "listar";
    }
    
    //mostrar el formulario
    @GetMapping("/nueva")
    public String mostrarFormularioPersona(Model model){
        model.addAttribute("persona", new Persona());
        model.addAttribute("accion", "/nueva");
        return "formulario";
    }
    //Crear la persona el la bbdd
    @PostMapping("/nueva")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaService.crearPersona(persona);
        return "redirect:/";
    }
    //Cremos el formulario para actualizar datos
    @GetMapping("/editar/{id_persona}")
    public String mostrarFormularioPersona(@PathVariable int id_persona,@ModelAttribute Persona persona,Model model){
        model.addAttribute("persona", persona);
        model.addAttribute("accion", "/editar/"+ id_persona);
        return "formulario";
    }
    
    //Actualizar registro en la base de datos
    @PostMapping("/editar/{id_persona}")
    public String actualizarPersona(@PathVariable int id_persona,@ModelAttribute Persona persona){
        personaService.actualizarPerId(id_persona, persona);
        return "redirect:/";
    }
    
    //Eliminar datos
    @GetMapping("/eliminar/{id_persona}")
    public String liminarPersona(@PathVariable int id_persona){
        personaService.eliminarPersona(id_persona);
        return "redirect:/";
    }
}
