package com.pyto.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyto.core.model.PaisModel;
import com.pyto.core.service.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisController {
	@Autowired
	private PaisService paisService;
	
	@GetMapping
	private ResponseEntity<List<PaisModel>> getAllPais(){
		return ResponseEntity.ok(paisService.findAll());
	}
}
