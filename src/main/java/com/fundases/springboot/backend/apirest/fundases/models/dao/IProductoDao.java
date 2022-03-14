package com.fundases.springboot.backend.apirest.fundases.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long> {

	public List<Producto> findByNombreContainingIgnoreCase(String term);
	
}
