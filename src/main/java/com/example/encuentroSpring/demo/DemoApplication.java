package com.example.encuentroSpring.demo;
import com.example.encuentroSpring.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication { //Metodos abstractos para poder llamar a la clase abstracta
        
        /*@Autowired
	private PersonaRepository personaRepository; // como no esta instanciado es nulo, pero eso se usa la anotacion Autowired para inyectarlo
        */
        @Autowired
        private PersonaService personaServicio;
        
        public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

       

}
