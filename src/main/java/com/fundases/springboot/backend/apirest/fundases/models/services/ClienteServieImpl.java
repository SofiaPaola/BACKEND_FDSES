package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundases.springboot.backend.apirest.fundases.models.dao.IClienteDao;
import com.fundases.springboot.backend.apirest.fundases.models.dao.IFacturaDao;
import com.fundases.springboot.backend.apirest.fundases.models.dao.IProductoDao;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Cliente;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Factura;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Producto;
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;

@Service
public class ClienteServieImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Ciudad> findAllCiudad() {
		return clienteDao.findAllCiudad();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAllTipoDocumento() {
		return clienteDao.findAllTipoDocumento();
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura saveFactura(Factura factura) {
		return facturaDao.save(factura);
	}

	@Override
	@Transactional
	public void deleteFacturaById(Long id) {
		facturaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findProductoByNombre(String term) {
		return productoDao.findByNombreContainingIgnoreCase(term);
	}
	
}
