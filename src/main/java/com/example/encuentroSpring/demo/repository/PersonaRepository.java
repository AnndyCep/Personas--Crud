
package com.example.encuentroSpring.demo.repository;

import com.example.encuentroSpring.demo.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository  // Se declara la anotacion para que pueda ser llamado
public interface PersonaRepository extends JpaRepository<Persona,Integer>{
  
}
