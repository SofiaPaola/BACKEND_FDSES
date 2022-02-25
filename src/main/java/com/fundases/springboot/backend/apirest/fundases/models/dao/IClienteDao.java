package com.fundases.springboot.backend.apirest.fundases.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {

	@Query("from Ciudad")
	public List<Ciudad> findAllCiudad();
	
}
