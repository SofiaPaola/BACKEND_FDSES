package com.fundases.springboot.backend.apirest.fundases.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Vendedor;

public interface IVendedorDao  extends JpaRepository<Vendedor, Long>{

	@Query("from Ciudad")
	public List<Ciudad> findAllCiudad();

	
	@Query("from TipoDocumento")
	public List<TipoDocumento> findAllTipoDocumentos();
	
	@Query("from Clima")
	public List<Clima> findAllClima();
	
	
	@Query("from Departamento")
	public List<Departamento> findAllDepartamento();
	
	
}
