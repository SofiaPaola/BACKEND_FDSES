package com.fundases.springboot.backend.apirest.fundases.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comp_solicitudes_compra_det")
public class CompraSolicitudCompraDetalle implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_solicitud_detalle")
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_elemento")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraElemento comp_elementos;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_solicitud_compra")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraSolicitudCompra comp_solicitudes_compra;
	
	private String proveedor_sugerido;
	
	private String especificaciones_tecnicas;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraEstado comp_estados;
	
	private String cantidad;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_necesidad;
	
	/*@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_centro_costo")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ;*/
	
	private String programado;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unidad_medida")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Unidad unidades;

	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompraElemento getComp_elementos() {
		return comp_elementos;
	}

	public void setComp_elementos(CompraElemento comp_elementos) {
		this.comp_elementos = comp_elementos;
	}

	public CompraSolicitudCompra getComp_solicitudes_compra() {
		return comp_solicitudes_compra;
	}

	public void setComp_solicitudes_compra(CompraSolicitudCompra comp_solicitudes_compra) {
		this.comp_solicitudes_compra = comp_solicitudes_compra;
	}

	public String getProveedor_sugerido() {
		return proveedor_sugerido;
	}

	public void setProveedor_sugerido(String proveedor_sugerido) {
		this.proveedor_sugerido = proveedor_sugerido;
	}

	public String getEspecificaciones_tecnicas() {
		return especificaciones_tecnicas;
	}

	public void setEspecificaciones_tecnicas(String especificaciones_tecnicas) {
		this.especificaciones_tecnicas = especificaciones_tecnicas;
	}

	public CompraEstado getComp_estados() {
		return comp_estados;
	}

	public void setComp_estados(CompraEstado comp_estados) {
		this.comp_estados = comp_estados;
	}
	
	public Unidad getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidad unidades) {
		this.unidades = unidades;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha_necesidad() {
		return fecha_necesidad;
	}

	public void setFecha_necesidad(Date fecha_necesidad) {
		this.fecha_necesidad = fecha_necesidad;
	}

	public String getProgramado() {
		return programado;
	}

	public void setProgramado(String programado) {
		this.programado = programado;
	}

}
