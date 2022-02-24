package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Tipo_Documento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Proveedor;

public interface IProveedorService {


	public List<Proveedor> findAll();
	
	public Page<Proveedor> findAll(Pageable pageable);
    
	public Proveedor findById(Long id);
	
	public Proveedor save(Proveedor vendedor);
	
	public void delete(Long id);
	
	public List<Ciudad> findAllCiudades();	
	public List<Tipo_Documento> findAllTipoDocumento();
}
