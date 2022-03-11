package com.fundases.springboot.backend.apirest.fundases.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Cliente;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;



public interface ICiudadDao  extends JpaRepository<Cliente, Long>  {
	
	@Query("from Clima")
	public List<Clima> findAllClimas();
	
	@Query("from Departamento")
	public List<Departamento> findAllDepartamentos();


}
