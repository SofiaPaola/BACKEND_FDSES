package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Vendedor;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;

public interface IVendedorService {

	public List<Vendedor> findAll();

	public Page<Vendedor> findAll(Pageable pageable);

	public Vendedor findById(Long id);

	public Vendedor save(Vendedor vendedor);

	public void delete(Long id);

	public List<Ciudad> findAllCiudad();

	public List<TipoDocumento> findAllTipoDocumento();

}