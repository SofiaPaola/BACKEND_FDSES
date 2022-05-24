package com.fundases.springboot.backend.apirest.fundases.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraElemento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraEstado;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompra;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompraDetalle;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Unidad;

public interface ICompraSolicitudCompraDetalleDao extends JpaRepository<CompraSolicitudCompraDetalle, Long> {

	@Query("from CompraElemento")
	public List<CompraElemento> findAllCompraElemento();
	
	@Query("from CompraSolicitudCompra")
	public List<CompraSolicitudCompra> findAllCompraSolicitudCompra();
	
	@Query("from CompraEstado")
	public List<CompraEstado> findAllCompraEstado();
	
	@Query("from Unidad")
	public List<Unidad> findAllUnidad();
	
}
