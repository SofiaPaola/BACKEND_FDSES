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

import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraElemento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraEstado;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompra;
import com.fundases.springboot.backend.apirest.fundases.models.entity.CompraSolicitudCompraDetalle;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Unidad;
import com.fundases.springboot.backend.apirest.fundases.models.services.ICompraSolicitudCompraDetalleService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CompraSolicitudCompraDetalleRestController {

	@Autowired
	private ICompraSolicitudCompraDetalleService compraSolicitudCompraDetalleService;

	@GetMapping("/solicitudCompraDetalles")
	public List<CompraSolicitudCompraDetalle> index() {
		return compraSolicitudCompraDetalleService.findAll();
	}

	@GetMapping("/solicitudCompraDetalles/page/{page}")
	public Page<CompraSolicitudCompraDetalle> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 8);
		return compraSolicitudCompraDetalleService.findAll(pageable);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/solicitudCompraDetalles/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		CompraSolicitudCompraDetalle solicitudCompraDetalle = null;

		Map<String, Object> response = new HashMap<>();

		try {
			solicitudCompraDetalle = compraSolicitudCompraDetalleService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (solicitudCompraDetalle == null) {
			response.put("mensaje", "El detalle de la solicitud de compra ID: "
					.concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<CompraSolicitudCompraDetalle>(solicitudCompraDetalle, HttpStatus.OK);

	}

	@Secured("ROLE_ADMIN")
	@PostMapping("/solicitudCompraDetalles")
	public ResponseEntity<?> create(@Valid @RequestBody CompraSolicitudCompraDetalle solicitudCompraDetalle,
			BindingResult result) {

		CompraSolicitudCompraDetalle solicitudCompraDetalleNew = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			solicitudCompraDetalleNew = compraSolicitudCompraDetalleService.save(solicitudCompraDetalle);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El detalle de solicitud de compra ha sido creado con éxito!");
		response.put("solicitudCompraDetalle", solicitudCompraDetalleNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured("ROLE_ADMIN")
	@PutMapping("/solicitudCompraDetalles/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody CompraSolicitudCompraDetalle solicitudCompraDetalle,
			BindingResult result, @PathVariable Long id) {

		CompraSolicitudCompraDetalle solicitudCompraDetalleActual = compraSolicitudCompraDetalleService.findById(id);

		CompraSolicitudCompraDetalle solicitudCompraDetalleUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		if (solicitudCompraDetalleActual == null) {
			response.put("mensaje", "Error: No se pudo editar, el detalle de la solicitud de compra ID: "
					.concat(id.toString().concat("No existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			solicitudCompraDetalleActual.setComp_elementos(solicitudCompraDetalle.getComp_elementos());
			solicitudCompraDetalleActual
					.setComp_solicitudes_compra(solicitudCompraDetalle.getComp_solicitudes_compra());
			solicitudCompraDetalleActual.setProveedor_sugerido(solicitudCompraDetalle.getProveedor_sugerido());
			solicitudCompraDetalleActual
					.setEspecificaciones_tecnicas(solicitudCompraDetalle.getEspecificaciones_tecnicas());
			solicitudCompraDetalleActual.setComp_estados(solicitudCompraDetalle.getComp_estados());
			solicitudCompraDetalleActual.setCantidad(solicitudCompraDetalle.getCantidad());
			solicitudCompraDetalleActual.setFecha_necesidad(solicitudCompraDetalle.getFecha_necesidad());
			solicitudCompraDetalleActual.setCentros_costo(solicitudCompraDetalle.getCentros_costo());
			solicitudCompraDetalleActual.setProgramado(solicitudCompraDetalle.getProgramado());
			solicitudCompraDetalleActual.setUnidades(solicitudCompraDetalle.getUnidades());

			solicitudCompraDetalleUpdated = compraSolicitudCompraDetalleService.save(solicitudCompraDetalleActual);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el detalle de solicitud de compra en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El detalle de solicitud de compra ha sido actualizado con éxito!");
		response.put("solicitudCompraDetalle", solicitudCompraDetalleUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@Secured("ROLE_ADMIN")
	@DeleteMapping("/solicitudCompraDetalles/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			compraSolicitudCompraDetalleService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el detalle de solicitud de compra de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El detalle de solicitud de compra se eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/solicitudCompraDetalles/compraElemento")
	public List<CompraElemento> listarCompraElemento() {
		return compraSolicitudCompraDetalleService.findAllCompraElemento();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/solicitudCompraDetalles/compraSolicitud")
	public List<CompraSolicitudCompra> listarSolictudCompra() {
		return compraSolicitudCompraDetalleService.findAllCompraSolicitudCompra();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/solicitudCompraDetalles/compraEstado")
	public List<CompraEstado> listarEstado() {
		return compraSolicitudCompraDetalleService.findAllCompraEstado();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/solicitudCompraDetalles/unidad")
	public List<Unidad> listarUnidad() {
		return compraSolicitudCompraDetalleService.findAllUnidad();
	}

}
