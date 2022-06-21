package com.fundases.springboot.backend.apirest.fundases.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RestController;

import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraEstado;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompra;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Usuario;
import com.fundases.springboot.backend.apirest.fundases.models.services.ICompraSolicitudCompraService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CompraSolicitudCompraRestController {

	@Autowired
	private ICompraSolicitudCompraService solicitudCompraService;

	@GetMapping("/solicitudCompra")
	public List<CompraSolicitudCompra> index() {
		return solicitudCompraService.findAll();
	}

	@GetMapping("/solicitudCompra/page/{page}")
	public Page<CompraSolicitudCompra> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 8);
		return solicitudCompraService.findAll(pageable);
	}

	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/solicitudCompra/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		CompraSolicitudCompra solicitudCompra = null;
		Map<String, Object> response = new HashMap<>();

		try {
			solicitudCompra = solicitudCompraService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Erro al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (solicitudCompra == null) {
			response.put("mensaje",
					"La solicitud de compra ID: ".concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CompraSolicitudCompra>(solicitudCompra, HttpStatus.OK);
	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/solicitudCompra")
	public ResponseEntity<?> create(@Valid @RequestBody CompraSolicitudCompra solicitudCompra, BindingResult result) {

		CompraSolicitudCompra solicitudCompraNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			solicitudCompraNew = solicitudCompraService.save(solicitudCompra);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensjae", "La solicitud de compra ha sido creado con exito");
		response.put("solicitudCompra", solicitudCompraNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/solicitudCompra/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody CompraSolicitudCompra solicitudCompra, BindingResult result,
			@PathVariable Long id) {

		CompraSolicitudCompra solicitudCompraActual = solicitudCompraService.findById(id);

		CompraSolicitudCompra solicitudCompraUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (solicitudCompraActual == null) {
			response.put("mensaje", "Error: no se puede editar, la solicitud de compra ID: "
					.concat(id.toString().concat(" No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			solicitudCompraActual.setUsuarios(solicitudCompra.getUsuarios());
			solicitudCompraActual.setEstados(solicitudCompra.getEstados());
			solicitudCompraActual.setFecha_registro(solicitudCompra.getFecha_registro());

			solicitudCompraUpdated = solicitudCompraService.save(solicitudCompraActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la solicitud de compra en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La solicitud de compra ha sido actualizada con exito");
		response.put("solicitudCompra", solicitudCompraUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/solicitudCompra/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			solicitudCompraService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la solicitud de compra de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La solicitud de compra eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/solicitudCompra/compraEstado")
	public List<CompraEstado> listarEstado() {
		return solicitudCompraService.findAllCompraEstado();
	}
	
	@Secured({"ROLE_ADMIN", "ROLE_CLIENTE"})
	@GetMapping("/solicitudCompra/usuario")
	public List<Usuario> listarUsuario() {
		return solicitudCompraService.findAllUsuario();
	}
	
}
