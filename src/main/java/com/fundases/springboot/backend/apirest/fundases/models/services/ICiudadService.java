package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;

public interface ICiudadService {
	
public List<Clima> findAllClimas();		
	
public List<Departamento> findAllDepartamentos();
	

}


