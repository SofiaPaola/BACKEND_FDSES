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
@Table(name = "comp_eval_prov_parametros")
public class CompraEvalProvParametros implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_parametro_evalu")
	private Long id;
	
	private String parametro;
		
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraEvalprovCategoria evalprovcategoria;
	
	private String descripcion;
	
	private Long calificacion;
	
	private float porcentaje_base;
	
	private Long seccion_subcategoria;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public CompraEvalprovCategoria getEvalprovcategoria() {
		return evalprovcategoria;
	}

	public void setEvalprovcategoria(CompraEvalprovCategoria evalprovcategoria) {
		this.evalprovcategoria = evalprovcategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Long calificacion) {
		this.calificacion = calificacion;
	}

	public float getPorcentaje_base() {
		return porcentaje_base;
	}

	public void setPorcentaje_base(float porcentaje_base) {
		this.porcentaje_base = porcentaje_base;
	}

	public Long getSeccion_subcategoria() {
		return seccion_subcategoria;
	}

	public void setSeccion_subcategoria(Long seccion_subcategoria) {
		this.seccion_subcategoria = seccion_subcategoria;
	}

	private static final long serialVersionUID = 1L;
}
