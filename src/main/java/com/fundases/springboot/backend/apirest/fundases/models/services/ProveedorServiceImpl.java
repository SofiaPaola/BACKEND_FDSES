package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.fundases.springboot.backend.apirest.fundases.models.dao.IProveedorDao;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Tipo_Documento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Proveedor;

public class ProveedorServiceImpl {

	@Autowired
	private IProveedorDao proveedorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> findAll() {
		return (List<Proveedor>) proveedorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Proveedor> findAll(Pageable pageable) {
		
		return proveedorDao.findAll(pageable);		
	}


	@Override
	@Transactional
	public Proveedor findById(Long id) {
		// TODO Auto-generated method stub
		return proveedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedorDao.save(vendedor);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		proveedorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findAllCiudades() {
		
		return proveedorDao.findAllCiudades();
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Tipo_Documento> findAllTipo_Documento() {
		// TODO Auto-generated method stub
		return proveedorDao.findAllTipoDocumento();
	}

}
