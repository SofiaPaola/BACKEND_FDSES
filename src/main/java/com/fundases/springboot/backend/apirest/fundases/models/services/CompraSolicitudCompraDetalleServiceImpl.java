package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundases.springboot.backend.apirest.fundases.models.dao.ICompraElementoDao;
import com.fundases.springboot.backend.apirest.fundases.models.dao.ICompraSolicitudCompraDetalleDao;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CentroCosto;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraElemento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraEstado;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompra;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompraDetalle;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Unidad;

@Service
public class CompraSolicitudCompraDetalleServiceImpl implements ICompraSolicitudCompraDetalleService {

	@Autowired
	private ICompraSolicitudCompraDetalleDao compraSolicitudCompraDetalleDao;
	
	@Autowired
	private ICompraElementoDao compraElementoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CompraSolicitudCompraDetalle> findAll() {
		return (List<CompraSolicitudCompraDetalle>) compraSolicitudCompraDetalleDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<CompraSolicitudCompraDetalle> findAll(Pageable pageable) {
		return compraSolicitudCompraDetalleDao.findAll(pageable);
	}

	@Override
	@Transactional
	public CompraSolicitudCompraDetalle findById(Long id) {
		return compraSolicitudCompraDetalleDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CompraSolicitudCompraDetalle save(CompraSolicitudCompraDetalle compraSolicitudCompraDetalle) {
		return compraSolicitudCompraDetalleDao.save(compraSolicitudCompraDetalle);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		compraSolicitudCompraDetalleDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompraElemento> findAllCompraElementos() {
		return compraSolicitudCompraDetalleDao.findAllCompraElementos();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompraSolicitudCompra> findAllCompraSolicitudCompra() {
		return compraSolicitudCompraDetalleDao.findAllCompraSolicitudCompra();
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompraEstado> findAllCompraEstado() {
		return compraSolicitudCompraDetalleDao.findAllCompraEstado();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Unidad> findAllUnidad() {
		return compraSolicitudCompraDetalleDao.findAllUnidad();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<CompraElemento> findElementoByNombre(String term) {
		return compraElementoDao.findByNombreContainingIgnoreCase(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<CentroCosto> findAllCentroCostos() {
		return compraSolicitudCompraDetalleDao.findAllCentroCosto();
	}

}
