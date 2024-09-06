package com.pyto.core.controller;

import java.io.Console;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyto.core.model.PersonaModel;
import com.pyto.core.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	private ResponseEntity<List<PersonaModel>> getAllPersonas (){
		return ResponseEntity.ok(personaService.findAll());
	}
	
	@PostMapping()
	private ResponseEntity<PersonaModel> savePersona(@RequestBody PersonaModel persona){
		try {
			PersonaModel personaGuardada = personaService.save(persona);
			return ResponseEntity.created(new URI("/persona/"+personaGuardada.getId())).body(personaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/*
	@GetMapping("/{id}")
	private ResponseEntity<Optional<PersonaModel>> getPersonaById(@PathVariable ("id") int id){
		return ResponseEntity.ok(personaService.findById(id));
	}
	*/
	
	@DeleteMapping(value= "/delete/{id}")
	private ResponseEntity<Boolean> deletePersona(@PathVariable ("id") int id){
		personaService.deleteById(id);
		return ResponseEntity.ok(!(personaService.findById(id)!=null));
	}
	
	@PutMapping(value= "/edit/{id}")
	private ResponseEntity<PersonaModel> updatePersona(@PathVariable("id") int id, @RequestBody PersonaModel persona) {
	    try {
	        Optional<PersonaModel> optionalPersona = personaService.findById(id);
	        
	        if (!optionalPersona.isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        PersonaModel personaExistente = optionalPersona.get();
	        personaExistente.setNombre(persona.getNombre());
	        personaExistente.setAp(persona.getAp());
	        personaExistente.setAm(persona.getAm());
	        personaExistente.setEdad(persona.getEdad());
	        personaExistente.setPais(persona.getPais());
	        personaExistente.setestado(persona.getestado());
	        
	        
	        PersonaModel personaActualizada = personaService.save(personaExistente);
	        
	        return ResponseEntity.ok(personaActualizada);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }
	}
	
}
