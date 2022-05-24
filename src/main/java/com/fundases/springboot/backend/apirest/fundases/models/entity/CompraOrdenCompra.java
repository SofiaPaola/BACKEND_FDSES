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
@Table(name = "comp_ordenes_compra")
public class CompraOrdenCompra implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_orden_compra")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_solicitud;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_entrega;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Proveedor proveedores;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_lugar_entrega")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraLugarEntrega comp_lugar_entrega;
	
	private String precio_letras;
	
	private String consecutivo;
	
	private String observaciones;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraEstado comp_estados;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_forma_pago")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Proveedor proveedorFormaPago;
	
	private String ruta_planilla_pago_eps;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public Date getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public Proveedor getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedor proveedores) {
		this.proveedores = proveedores;
	}

	public Proveedor getProveedorFormaPago() {
		return proveedorFormaPago;
	}

	public void setProveedorFormaPago(Proveedor proveedorFormaPago) {
		this.proveedorFormaPago = proveedorFormaPago;
	}

	public CompraEstado getComp_estados() {
		return comp_estados;
	}

	public void setComp_estados(CompraEstado comp_estados) {
		this.comp_estados = comp_estados;
	}

	public CompraLugarEntrega getComp_lugar_entrega() {
		return comp_lugar_entrega;
	}

	public void setComp_lugar_entrega(CompraLugarEntrega comp_lugar_entrega) {
		this.comp_lugar_entrega = comp_lugar_entrega;
	}

	public String getPrecio_letras() {
		return precio_letras;
	}

	public void setPrecio_letras(String precio_letras) {
		this.precio_letras = precio_letras;
	}

	public String getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(String consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRuta_planilla_pago_eps() {
		return ruta_planilla_pago_eps;
	}

	public void setRuta_planilla_pago_eps(String ruta_planilla_pago_eps) {
		this.ruta_planilla_pago_eps = ruta_planilla_pago_eps;
	}

	private static final long serialVersionUID = 1L;

}
