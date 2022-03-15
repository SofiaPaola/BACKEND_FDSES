package com.fundases.springboot.backend.apirest.fundases.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//import org.springframework.data.repository.CrudRepository;   el JpaRepository  ya incluye el CrudRepository  por eso se quita y se deja solo JpaRepository 
import com.fundases.springboot.backend.apirest.fundases.models.entity.Proveedor;
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;

public interface IProveedorDao extends JpaRepository<Proveedor, Long>{
	
	@Query("from Ciudad")
	public List<Ciudad> findAllCiudad();
	
	@Query("from TipoDocumento")
	public List<TipoDocumento> findAllTipoDocumento();
	
	@Query("from Clima")
	public List<Clima> findAllClima();
	
	@Query("from Departamento")
	public List<Departamento> findAllDepartamento();
	
}