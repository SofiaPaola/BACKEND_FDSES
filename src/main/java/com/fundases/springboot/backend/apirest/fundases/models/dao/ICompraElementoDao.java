package com.fundases.springboot.backend.apirest.fundases.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraElemento;

public interface ICompraElementoDao extends CrudRepository<CompraElemento, Long> {
	public List<CompraElemento> findByNombreContainingIgnoreCase(String term);
}
