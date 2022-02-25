package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundases.springboot.backend.apirest.fundases.models.dao.IProveedorDao;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Proveedor;
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;

@Service
public class ProveedorServiceImpl implements IProveedorService{

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
	@Transactional(readOnly = true)
	public Proveedor findById(Long id) {
		return proveedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Proveedor save(Proveedor proveedor) {
		return proveedorDao.save(proveedor);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		proveedorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findAllCiudad() {
		return proveedorDao.findAllCiudad();
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAllTipoDocumento() {
		return proveedorDao.findAllTipoDocumento();
	}
	
	
}