
package com.example.encuentroSpring.demo.service.impl;

import com.example.encuentroSpring.demo.entities.Persona;
import com.example.encuentroSpring.demo.repository.PersonaRepository;
import com.example.encuentroSpring.demo.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    
    
    //Se necesita tener interaccion con la capa de repository, para tener acceso a la base de datos
    //por lo que se inyecta la interfaz PersonaRepository, mediante la anotacion Autowired
    @Autowired
    private PersonaRepository personaRepository;
    //Se implementan todos los metodos abstractos

    @Override
    public List<Persona> obtenerTodas() {
        return personaRepository.findAll();// retorna una lista con las personas
    }

    @Override
    public Persona obtenerPorId(int id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPerId(int id, Persona persona) {
        
        //Traemos de la bd la persona, por ello lo busca a traves de su ID
        Persona personaddbb = personaRepository.findById(id).orElse(null);
        
        //Comparamos si persona tiene un objeto si es asi entra.
        if (personaddbb != null ) {
            //Seteamos los datos del objeto que se trae como parametro al obejeto que se creo
            personaddbb.setNombre(persona.getNombre());
            personaddbb.setApellido(persona.getApellido());
            //retoramos el objeto con los datos actualizados de nuevo a la base de datos
            return personaRepository.save(personaddbb);
        }
        
        // Si no encuentra nada por el ID retornamos null
        return null;
    }

    @Override
    public void eliminarPersona(int id) {
        personaRepository.deleteById(id);
    }

    @Override
    public long contarServicio() {
        return personaRepository.count();
    }
    
}
