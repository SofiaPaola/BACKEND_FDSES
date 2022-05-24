package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraElemento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraEstado;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompra;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompraDetalle;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Unidad;

public interface ICompraSolicitudCompraDetalleService {
	
	public List<CompraSolicitudCompraDetalle> findAll();
	
	public Page<CompraSolicitudCompraDetalle> findAll(Pageable pageable);
	
	public CompraSolicitudCompraDetalle findById(Long id);
	
	public CompraSolicitudCompraDetalle save(CompraSolicitudCompraDetalle compraSolicitudCompraDetalle);
	
	public void delete(Long id);
	
	public List<CompraElemento> findAllCompraElemento();
	
	public List<CompraSolicitudCompra> findAllCompraSolicitudCompra();

	public List<CompraEstado> findAllCompraEstado();
	
	public List<Unidad> findAllUnidad();

}
