package com.pyto.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyto.core.model.EstadoModel;
import com.pyto.core.service.EstadoService;

@RestController
@RequestMapping("/estado")
public class EstadoController {
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	private ResponseEntity<List<EstadoModel>> getAllestado(){
		return ResponseEntity.ok(estadoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<EstadoModel>> getAllestadoByPais(@PathVariable("id") int id) {
	    return ResponseEntity.ok(estadoService.findAllByCountry(id));
	}

}
