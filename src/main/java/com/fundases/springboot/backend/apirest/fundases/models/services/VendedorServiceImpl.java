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
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;

@Service
public class VendedorServiceImpl implements IVendedorService {
	
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
	@Transactional(readOnly = true)
	public Vendedor findById(Long id) {
		return vendedorDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Vendedor save(Vendedor vendedor) {
		return vendedorDao.save(vendedor);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		vendedorDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findAllCiudad() {
		return vendedorDao.findAllCiudad();
	}

	
	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAllTipoDocumento() {
		return vendedorDao.findAllTipoDocumento();
	}

}
