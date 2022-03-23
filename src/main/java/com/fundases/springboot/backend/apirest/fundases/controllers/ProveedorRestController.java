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

import com.fundases.springboot.backend.apirest.fundases.models.entity.Proveedor;
import com.fundases.springboot.backend.apirest.fundases.models.entity.TipoDocumento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Ciudad;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;
import com.fundases.springboot.backend.apirest.fundases.models.services.IProveedorService;
//import com.fundases.springboot.backend.apirest.fundases.models.services.IUploadFileService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProveedorRestController {
	@Autowired
	private IProveedorService proveedorService;

	// @Autowired
	// private IUploadFileService uploadService;

	@GetMapping("/proveedores")
	public List<Proveedor> index() {
		return proveedorService.findAll();
	}

	@GetMapping("/proveedores/page/{page}")
	public Page<Proveedor> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 5);
		return proveedorService.findAll(pageable);
	}

	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/proveedores/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Proveedor proveedor = null;

		Map<String, Object> response = new HashMap<>();

		try {
			proveedor = proveedorService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (proveedor == null) {

			response.put("mensaje", "El proveedor ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);

	};

	@Secured("ROLE_ADMIN")
	@PostMapping("/proveedores")
	public ResponseEntity<?> create(@Valid @RequestBody Proveedor proveedor, BindingResult result) {

		Proveedor proveedorNew = null;
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
			proveedorNew = proveedorService.save(proveedor);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El proveedor ha sido creado con Exito!");
		response.put("proveedor", proveedorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/proveedores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Valid @RequestBody Proveedor proveedor, BindingResult result,
			@PathVariable Long id) {
		Proveedor proveedorActual = proveedorService.findById(id);

		Proveedor proveedorUpdate = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (proveedorActual == null) {

			response.put("mensaje", "Error no se pudo editar, El proveedor ID: "
					.concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			proveedorActual.setDocumento(proveedor.getDocumento());
			proveedorActual.setNombre(proveedor.getNombre());
			proveedorActual.setDireccion(proveedor.getDireccion());
			proveedorActual.setTelefono(proveedor.getTelefono());
			proveedorActual.setCelular(proveedor.getCelular());
			proveedorActual.setEmail(proveedor.getEmail());
			proveedorActual.setFecha_ingreso(proveedor.getFecha_ingreso());
			proveedorActual.setCiudad(proveedor.getCiudad());
			proveedorActual.setTipo_documento(proveedor.getTipo_documento());

			proveedorUpdate = proveedorService.save(proveedorActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El proveedor ha sido actualizado con Exito!");
		response.put("proveedor", proveedorUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/proveedores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {

			// Proveedor proveedor = proveedorService.findById(id);
			// String nombreFotoAnterior = vendedor.getFoto();

			// uploadService.eliminar(nombreFotoAnterior);
			proveedorService.delete(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el proveedor en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El proveedor ha sido eliminado con Exito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	};

//@PostMapping("/vendedores/upload")
//public  ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
//	
//	Map<String, Object> response = new HashMap<>();
//	
//	Proveedor vendedor = vendedorService.findById(id);
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
//		response.put("vendedor", vendedor);
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
	@GetMapping("/proveedores/ciudades")
	public List<Ciudad> listarCiudades() {
		return proveedorService.findAllCiudad();
	}

	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/proveedores/tipos_documentos")
	public List<TipoDocumento> listarTipos_Documnetos() {
		return proveedorService.findAllTipoDocumento();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/proveedores/climas")
	public List<Clima> listarClimas() {
		return proveedorService.findAllClima();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/proveedores/departamentos")
	public List<Departamento> listarDepatamentos() {
		return proveedorService.findAllDepartamento();
	}
}