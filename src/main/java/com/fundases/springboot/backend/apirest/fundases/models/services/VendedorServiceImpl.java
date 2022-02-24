package com.fundases.springboot.backend.apirest.fundases.models.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundases.springboot.backend.apirest.fundases.models.dao.IVendedorDao;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Vendedor;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Tipo_Documento;

public class VendedorServiceImpl {
	
	@Autowired
	private IVendedorDao vendedorDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> findAll() {
		return (List<Vendedor>) vendedorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Vendedor> findAll(Pageable pageable) {
		
		return vendedorDao.findAll(pageable);		
	}


	@Override
	@Transactional
	public Vendedor findById(Long id) {
		// TODO Auto-generated method stub
		return vendedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Vendedor save(Vendedor vendedor) {
		// TODO Auto-generated method stub
		return vendedorDao.save(vendedor);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		vendedorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findAllCiudades() {
		
		return vendedorDao.findAllCiudades();
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<Tipo_Documento> findAllTipo_Documento() {
		// TODO Auto-generated method stub
		return vendedorDao.findAllTipoDocumento();
	}

}
