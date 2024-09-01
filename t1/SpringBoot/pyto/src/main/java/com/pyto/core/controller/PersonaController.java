package com.pyto.core.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping
	private ResponseEntity<PersonaModel> savePersona(@RequestBody PersonaModel persona){
		try {
			PersonaModel personaGuardada = personaService.save(persona);
			return ResponseEntity.created(new URI("/persona/"+personaGuardada.getId())).body(personaGuardada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
