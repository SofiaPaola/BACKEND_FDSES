package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente save(Cliente cliente);

	public void delete(Long id);

}
