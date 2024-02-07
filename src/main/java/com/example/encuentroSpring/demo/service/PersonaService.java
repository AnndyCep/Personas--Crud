
package com.example.encuentroSpring.demo.service;

import com.example.encuentroSpring.demo.entities.Persona;
import java.util.List;


public interface PersonaService {
    
    //Definir los metodos de negocio
    
    //Lista de personas
    List<Persona> obtenerTodas();
    
    //Obtener persona por id
    Persona obtenerPorId(int id);
    
    //Crear una persona por id
    Persona crearPersona(Persona persona);
    
    //Actualizar persona por id
    Persona actualizarPerId(int id,Persona persona);
    
    //Borrar persona
    void eliminarPersona(int id);
    
    long contarServicio();
    
    //Una vez finalizados los metodos de negocio se implementan en la clase.
}
