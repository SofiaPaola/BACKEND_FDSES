package com.fundases.springboot.backend.apirest.fundases.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comp_ordenes_compra_det")
public class CompraOrdenCompraDetalle implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_orden_compra_det")
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_orden_compra")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraOrdenCompra comp_ordenes_compra;
	
	/*@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_comite_compra")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ;*/
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_solicitud_cotizacion_det")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraSolicitudCotizacionDetalle comp_solicitudes_cotizacion_det;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unidad_medida")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Unidad unidades;
	
	private String cantidad;
	
	private String valor_unit_sin_iva;
	
	private String iva;
	
	private String valor_total_con_iva;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraEstado comp_estdados;

	private String motivo_decision;
	
	private String observaciones;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompraOrdenCompra getComp_orden_compra() {
		return comp_ordenes_compra;
	}

	public void setCompra_orden_compra(CompraOrdenCompra comp_ordenes_compra) {
		this.comp_ordenes_compra = comp_ordenes_compra;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getValor_unit_sin_iva() {
		return valor_unit_sin_iva;
	}

	public void setValor_unit_sin_iva(String valor_unit_sin_iva) {
		this.valor_unit_sin_iva = valor_unit_sin_iva;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getValor_total_con_iva() {
		return valor_total_con_iva;
	}

	public void setValor_total_con_iva(String valor_total_con_iva) {
		this.valor_total_con_iva = valor_total_con_iva;
	}

	public CompraOrdenCompra getComp_ordenes_compra() {
		return comp_ordenes_compra;
	}

	public void setComp_ordenes_compra(CompraOrdenCompra comp_ordenes_compra) {
		this.comp_ordenes_compra = comp_ordenes_compra;
	}

	public CompraSolicitudCotizacionDetalle getComp_solicitudes_cotizacion_det() {
		return comp_solicitudes_cotizacion_det;
	}

	public void setComp_solicitudes_cotizacion_det(CompraSolicitudCotizacionDetalle comp_solicitudes_cotizacion_det) {
		this.comp_solicitudes_cotizacion_det = comp_solicitudes_cotizacion_det;
	}

	public Unidad getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidad unidades) {
		this.unidades = unidades;
	}

	public CompraEstado getComp_estdados() {
		return comp_estdados;
	}

	public void setComp_estdados(CompraEstado comp_estdados) {
		this.comp_estdados = comp_estdados;
	}

	public String getMotivo_decision() {
		return motivo_decision;
	}

	public void setMotivo_decision(String motivo_decision) {
		this.motivo_decision = motivo_decision;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	private static final long serialVersionUID = 1L;

}
