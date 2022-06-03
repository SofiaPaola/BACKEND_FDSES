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
@Table(name = "comp_solicitudes_cotizacion_det")
public class CompraSolicitudCotizacionDetalle implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_solicitud_cotizacion_det")
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_solicitud_cotizacion")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CompraSolicitudCotizacion comp_solicitud_cotizacion;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_solicitud_detalle")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CompraSolicitudCompraDetalle comp_solicitud_compra_det;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unidad_medida")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Unidad unidades;

	private Integer cantidad;

	private Double valor_unitario_sin_iva;

	private Double descuento;

	private Double iva;

	private Double valor_unitario_con_iva;

	private Double valor_total_con_iva;

	@Temporal(TemporalType.DATE)
	private Date fecha_solicitud;

	private String ruta_archivo_cotizacion;

	private String marca;

	@Temporal(TemporalType.DATE)
	private Date fecha_limite_entrega;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CompraEstado compra_estdado;

	@Temporal(TemporalType.DATE)
	private Date fecha_envio_correo;

	@Temporal(TemporalType.DATE)
	private Date fecha_respuesta_correo;

	private String observaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompraSolicitudCotizacion getComp_solicitud_cotizacion() {
		return comp_solicitud_cotizacion;
	}

	public void setCompra_solicitud_cotizacion(CompraSolicitudCotizacion comp_solicitud_cotizacion) {
		this.comp_solicitud_cotizacion = comp_solicitud_cotizacion;
	}

	public CompraSolicitudCompraDetalle getComp_solicitud_compra_det() {
		return comp_solicitud_compra_det;
	}

	public void setCompra_solicitud_compra_detalle(CompraSolicitudCompraDetalle comp_solicitud_compra_det) {
		this.comp_solicitud_compra_det = comp_solicitud_compra_det;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValor_unitario_sin_iva() {
		return valor_unitario_sin_iva;
	}

	public void setValor_unitario_sin_iva(Double valor_unitario_sin_iva) {
		this.valor_unitario_sin_iva = valor_unitario_sin_iva;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getValor_unitario_con_iva() {
		return valor_unitario_con_iva;
	}

	public void setValor_unitario_con_iva(Double valor_unitario_con_iva) {
		this.valor_unitario_con_iva = valor_unitario_con_iva;
	}

	public Double getValor_total_con_iva() {
		return valor_total_con_iva;
	}

	public void setValor_total_con_iva(Double valor_total_con_iva) {
		this.valor_total_con_iva = valor_total_con_iva;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public String getRuta_archivo_cotizacion() {
		return ruta_archivo_cotizacion;
	}

	public void setRuta_archivo_cotizacion(String ruta_archivo_cotizacion) {
		this.ruta_archivo_cotizacion = ruta_archivo_cotizacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getFecha_limite_entrega() {
		return fecha_limite_entrega;
	}

	public void setFecha_limite_entrega(Date fecha_limite_entrega) {
		this.fecha_limite_entrega = fecha_limite_entrega;
	}

	public CompraEstado getCompra_estdado() {
		return compra_estdado;
	}

	public void setCompra_estdado(CompraEstado compra_estdado) {
		this.compra_estdado = compra_estdado;
	}

	public Date getFecha_envio_correo() {
		return fecha_envio_correo;
	}

	public void setFecha_envio_correo(Date fecha_envio_correo) {
		this.fecha_envio_correo = fecha_envio_correo;
	}

	public Date getFecha_respuesta_correo() {
		return fecha_respuesta_correo;
	}

	public void setFecha_respuesta_correo(Date fecha_respuesta_correo) {
		this.fecha_respuesta_correo = fecha_respuesta_correo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Unidad getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidad unidades) {
		this.unidades = unidades;
	}

	public void setComp_solicitud_cotizacion(CompraSolicitudCotizacion comp_solicitud_cotizacion) {
		this.comp_solicitud_cotizacion = comp_solicitud_cotizacion;
	}

	public void setComp_solicitud_compra_det(CompraSolicitudCompraDetalle comp_solicitud_compra_det) {
		this.comp_solicitud_compra_det = comp_solicitud_compra_det;
	}

	private static final long serialVersionUID = 1L;

}
