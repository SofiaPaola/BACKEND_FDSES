package com.fundases.springboot.backend.apirest.fundases.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
