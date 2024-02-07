
package com.example.encuentroSpring.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="tbl_persona")
@Data // crear todos los getters y setters
@AllArgsConstructor // Crea un constructor con todos atributos
@NoArgsConstructor // Crea un contructor vacion 

public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generar de forma automatica autoincrementable
    private int id_persona;
    
    private String nombre;
    private String apellido;
 
    
}
