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
@Table(name = "comp_compras_resibidas")
public class CompraCompraResibida implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_compras_recibidas")
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_orden_compra_detalle")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraOrdenCompraDetalle comp_ordenes_compra_det;
	
	/*@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_responsable")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ;*/
	
	private String factura;
	
	private Integer cantidad_recibida;
	
	private Long no_entrega;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_recepcion;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_registro;
	
	private String numero_de_lote;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_vencimiento;
	
	private String observaciones;
	
	private String ruta_certificado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public Integer getCantidad_recibida() {
		return cantidad_recibida;
	}

	public void setCantidad_recibida(Integer cantidad_recibida) {
		this.cantidad_recibida = cantidad_recibida;
	}

	public Long getNo_entrega() {
		return no_entrega;
	}

	public void setNo_entrega(Long no_entrega) {
		this.no_entrega = no_entrega;
	}

	public Date getFecha_recepcion() {
		return fecha_recepcion;
	}

	public void setFecha_recepcion(Date fecha_recepcion) {
		this.fecha_recepcion = fecha_recepcion;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getNumero_de_lote() {
		return numero_de_lote;
	}

	public void setNumero_de_lote(String numero_de_lote) {
		this.numero_de_lote = numero_de_lote;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getRuta_certificado() {
		return ruta_certificado;
	}

	public void setRuta_certificado(String ruta_certificado) {
		this.ruta_certificado = ruta_certificado;
	}

	public CompraOrdenCompraDetalle getComp_ordenes_compra_det() {
		return comp_ordenes_compra_det;
	}

	public void setComp_ordenes_compra_det(CompraOrdenCompraDetalle comp_ordenes_compra_det) {
		this.comp_ordenes_compra_det = comp_ordenes_compra_det;
	}

	private static final long serialVersionUID = 1L;
}
