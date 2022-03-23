package com.fundases.springboot.backend.apirest.fundases.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Vendedor;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;
import com.fundases.springboot.backend.apirest.fundases.models.services.IVendedorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")

public class VendedorRestController {

	@Autowired
	private IVendedorService vendedorService;

	//@Autowired
	//private IUploadFileService uploadService;

	@GetMapping("/vendedores")
	public List<Vendedor> index() {
		return vendedorService.findAll();
	}

	@GetMapping("/vendedores/page/{page}")
	public Page<Vendedor> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 5);
		return vendedorService.findAll(pageable);
	}

	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/vendedores/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Vendedor vendedor = null;

		Map<String, Object> response = new HashMap<>();

		try {
			vendedor = vendedorService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (vendedor == null) {

			response.put("mensaje", "El vendedor ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Vendedor>(vendedor, HttpStatus.OK);

	};

	@Secured("ROLE_ADMIN")
	@PostMapping("/vendedores")
	public ResponseEntity<?> create(@Valid @RequestBody Vendedor cliente, BindingResult result) {

		Vendedor vendedorNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			// Forma anterior al JDK 8
			// List<String> errors = new ArrayList<>();
			// for(FieldError err: result.getFieldErrors())
			// errors.add("El campo " + err.getField() + "' "+ err.getDefaultMessage());
			// response.put("errors", errors);
			// return new ResponseEntity<Map<String,
			// Object>>(response,HttpStatus.BAD_REQUEST);

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			vendedorNew = vendedorService.save(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente ha sido creado con Exito!");
		response.put("cliente", vendedorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/vendedores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Valid @RequestBody Vendedor vendedor, BindingResult result,
			@PathVariable Long id) {
		Vendedor vendedorActual = vendedorService.findById(id);

		Vendedor vendedorUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (vendedorActual == null) {

			response.put("mensaje", "Error no se pudo editar, El vendedor ID: "
					.concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			vendedorActual.setDocumento(vendedor.getDocumento());
			vendedorActual.setNombre(vendedor.getNombre());
			vendedorActual.setDireccion(vendedor.getDireccion());
			vendedorActual.setTelefono(vendedor.getTelefono());
			vendedorActual.setCelular(vendedor.getCelular());
			vendedorActual.setEmail(vendedor.getEmail());
			vendedorActual.setFecha_ingreso(vendedor.getFecha_ingreso());
			vendedorActual.setCiudad(vendedor.getCiudad());
			vendedorActual.setTipo_documento(vendedor.getTipo_documento());

			vendedorUpdate = vendedorService.save(vendedorActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El vendedor ha sido actualizado con Exito!");
		response.put("vendedor", vendedorUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/vendedores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {

			//Vendedor vendedor = vendedorService.findById(id);
			// String nombreFotoAnterior = vendedor.getFoto();

			// uploadService.eliminar(nombreFotoAnterior);
			vendedorService.delete(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el vendedor en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El vendedor ha sido eliminado con Exito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	};

//@PostMapping("/vendedores/upload")
//public  ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
//	
//	Map<String, Object> response = new HashMap<>();
//	
//	Vendedor vendedor = vendedorService.findById(id);
//	if(!archivo.isEmpty()) {
//		
//		String nombreArchivo = null;
//			
//		try {
//			nombreArchivo =  uploadService.copiar(archivo);
//		} catch(IOException e){
//		 // TODO Auto-generated catch block
//			response.put("mensaje","Error al subir la imagen");
//			response.put("error",e.getMessage().concat(": ").concat(e.getCause().getMessage()));
//			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		String nombreFotoAnterior = vendedor.getFoto();
//		uploadService.eliminar(nombreFotoAnterior);				
//		
//		vendedor.setFoto(nombreArchivo);
//		vendedorService.save(vendedor);
//		response.put("cliente", vendedor);
//		response.put("mensaje", "Has subido correctamente la imagen :" + nombreArchivo);
//	}
//	
//	return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
//}
//
//@GetMapping("/uploads/img/{nombreFoto:.+}")
//public  ResponseEntity<Resource> VerFoto(@PathVariable String nombreFoto) {
//	
//	
//	 Resource recurso = null;
//	 
//	try {
//		recurso = uploadService.cargar(nombreFoto);
//	} catch (MalformedURLException e) {
//	
//		e.printStackTrace();
//	}
//	 
//	 HttpHeaders cabecera = new HttpHeaders();
//	 cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() +"\"");
//	 
//	return new ResponseEntity<Resource>(recurso,cabecera,HttpStatus.OK);
//}
//
//
	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/vendedores/ciudades")
	public List<Ciudad> listarCiudades() {
		return vendedorService.findAllCiudad();
	}

	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/vendedores/tipos_documentos")
	public List<TipoDocumento> listarTipos_Documnetos() {
		return vendedorService.findAllTipoDocumentos();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/vendedores/climas")
	public List<Clima> listarClimas() {
		return vendedorService.findAllClima();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/vendedores/departamento")
	public List<Departamento> listarDepatamentos() {
		return vendedorService.findAllDepartamento();
	}

}