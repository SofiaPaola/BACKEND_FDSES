package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.fundases.springboot.backend.apirest.fundases.models.dao.ICompraSolicitudCompraDao;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraEstado;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompra;

public class CompraSolicitudCompraServiceImpl implements ICompraSolicitudCompraService {

	@Autowired
	private ICompraSolicitudCompraDao compraSolicitudCompraDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CompraSolicitudCompra> findAll() {
		return (List<CompraSolicitudCompra>) compraSolicitudCompraDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<CompraSolicitudCompra> findAll(Pageable pageable) {
		return compraSolicitudCompraDao.findAll(pageable);
	}

	@Override
	@Transactional
	public CompraSolicitudCompra findById(Long id) {
		return compraSolicitudCompraDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CompraSolicitudCompra save(CompraSolicitudCompra compraSolicitudCompra) {
		return compraSolicitudCompraDao.save(compraSolicitudCompra);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		compraSolicitudCompraDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompraEstado> findAllCompraEstado() {
		return compraSolicitudCompraDao.findAllCompraEstado();
	}	
}
