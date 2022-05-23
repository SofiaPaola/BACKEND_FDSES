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
@Table(name = "comp_comite_actas")
public class CompraComiteActa implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_acta_comite")
	private Long id;

	@Temporal(TemporalType.TIME)
	private Date hora_inicio;
	
	@Temporal(TemporalType.TIME)
	private Date hora_fin;
	
	private String area;
	
	private String tipo_reunion;
	
	private String observaciones;
	
	private String comporomiso;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_comite;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraEstado comp_estados;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Date hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Date getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(Date hora_fin) {
		this.hora_fin = hora_fin;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTipo_reunion() {
		return tipo_reunion;
	}

	public void setTipo_reunion(String tipo_reunion) {
		this.tipo_reunion = tipo_reunion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getComporomiso() {
		return comporomiso;
	}

	public void setComporomiso(String comporomiso) {
		this.comporomiso = comporomiso;
	}

	public Date getFecha_comite() {
		return fecha_comite;
	}

	public void setFecha_comite(Date fecha_comite) {
		this.fecha_comite = fecha_comite;
	}

	public CompraEstado getComp_estados() {
		return comp_estados;
	}

	public void setComp_estados(CompraEstado comp_estados) {
		this.comp_estados = comp_estados;
	}

	private static final long serialVersionUID = 1L;

}
