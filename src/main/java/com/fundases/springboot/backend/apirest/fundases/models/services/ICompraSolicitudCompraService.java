package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraEstado;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompra;

public interface ICompraSolicitudCompraService {
	
	public List<CompraSolicitudCompra> findAll();
	
	public Page<CompraSolicitudCompra> findAll(Pageable pageable);
	
	public CompraSolicitudCompra findById(Long id);
	
	public CompraSolicitudCompra save(CompraSolicitudCompra compraSolicitudCompra);
	
	public void delete(Long id);
	
	public List<CompraEstado> findAllCompraEstado();

}
