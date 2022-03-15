package com.fundases.springboot.backend.apirest.fundases.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Cliente;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Factura;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Producto;
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);

	public void delete(Long id);
	
	public List<Ciudad> findAllCiudad();
	
	//public List<Ciudad> findCiudadByCiudad(String term);
	
	public List<TipoDocumento> findAllTipoDocumentos();
	
	public List<Clima> findAllClima();
	
	public List<Departamento> findAllDepartamento();
	
	public Factura findFacturaById(Long id);

	public Factura saveFactura(Factura factura);
	
	public void deleteFacturaById(Long id);
	
	public List<Producto> findProductoByNombre(String term);

}
