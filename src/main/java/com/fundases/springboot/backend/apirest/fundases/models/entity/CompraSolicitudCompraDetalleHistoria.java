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
@Table(name = "comp_solicitudes_compra_det_hist")
public class CompraSolicitudCompraDetalleHistoria implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_solicitud_detalle_hist_estdo")
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_solicitud_detalle")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraSolicitudCompraDetalle comp_solicitudes_compra_det;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraEstado comp_estados;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Usuario usuarios;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_registro;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompraSolicitudCompraDetalle getComp_solicitudes_compra_det() {
		return comp_solicitudes_compra_det;
	}

	public void setComp_solicitudes_compra_det(CompraSolicitudCompraDetalle comp_solicitudes_compra_det) {
		this.comp_solicitudes_compra_det = comp_solicitudes_compra_det;
	}

	public CompraEstado getComp_estados() {
		return comp_estados;
	}

	public void setComp_estados(CompraEstado comp_estados) {
		this.comp_estados = comp_estados;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	private static final long serialVersionUID = 1L;

}
