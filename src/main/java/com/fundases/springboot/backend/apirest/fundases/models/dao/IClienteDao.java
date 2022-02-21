package com.fundases.springboot.backend.apirest.fundases.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long> {
	
	

}
