package com.fundases.springboot.backend.apirest.fundases.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraEstado;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompra;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Usuario;

public interface ICompraSolicitudCompraDao extends JpaRepository<CompraSolicitudCompra, Long> {
	
	@Query("from CompraEstado")
	public List<CompraEstado> findAllCompraEstado();
	
	@Query("from Usuario")
	public List<Usuario> findAllUsuario();
	
}
