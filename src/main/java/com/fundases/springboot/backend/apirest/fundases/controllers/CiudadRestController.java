package com.fundases.springboot.backend.apirest.fundases.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;
import com.fundases.springboot.backend.apirest.fundases.models.services.ICiudadService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CiudadRestController {
	
	@Autowired
	private ICiudadService ciudadService;
	
	@GetMapping("/ciudades/departamentos")
	public List<Departamento> listarDepartamentos() {
		return ciudadService.findAllDepartamentos();
	}
	
	@GetMapping("/ciudades/climas")
	public List<Clima> listarClimas() {
		return ciudadService.findAllClimas();
	}


}
