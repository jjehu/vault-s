package com.pyto.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyto.core.model.DepartamentoModel;
import com.pyto.core.service.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping
	private ResponseEntity<List<DepartamentoModel>> getAllDepartamento(){
		return ResponseEntity.ok(departamentoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<DepartamentoModel>> getAllDepartamentoByPais(@PathVariable("id") int id) {
	    return ResponseEntity.ok(departamentoService.findAllByCountry(id));
	}

}
