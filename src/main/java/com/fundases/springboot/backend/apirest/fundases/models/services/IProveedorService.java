package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Proveedor;
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;

public interface IProveedorService {

	public List<Proveedor> findAll();

	public Page<Proveedor> findAll(Pageable pageable);

	public Proveedor findById(Long id);

	public Proveedor save(Proveedor proveedor);

	public void delete(Long id);

	public List<Ciudad> findAllCiudad();

	public List<TipoDocumento> findAllTipoDocumento();

	public List<Clima> findAllClima();

	public List<Departamento> findAllDepartamento();

}