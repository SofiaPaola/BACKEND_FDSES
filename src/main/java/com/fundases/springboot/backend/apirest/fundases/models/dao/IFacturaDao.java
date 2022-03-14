package com.fundases.springboot.backend.apirest.fundases.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}