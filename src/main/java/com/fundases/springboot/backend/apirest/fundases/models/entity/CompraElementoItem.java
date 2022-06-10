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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comp_elementos_item")
public class CompraElementoItem implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_elemento")
	private Long id;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_elemento")
	private CompraElemento comp_elementos;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_solicitud_detalle")
	private CompraSolicitudCompraDetalle comp_solicitudes_compra_det;
	
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

	public CompraSolicitudCompraDetalle getComp_solicitudes_compra_det() {
		return comp_solicitudes_compra_det;
	}

	public void setComp_solicitudes_compra_det(CompraSolicitudCompraDetalle comp_solicitudes_compra_det) {
		this.comp_solicitudes_compra_det = comp_solicitudes_compra_det;
	}

	private static final long serialVersionUID = 1L;

}
