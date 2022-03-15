package com.fundases.springboot.backend.apirest.fundases.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

@Entity
@Table(name = "ciudades")
public class Ciudad implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_ciudad")
	private Long id;
	
	@Column(name = "ciudad")
	private String nombre;
	
	private String altitud;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_clima")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Clima clima;
	
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_departamento")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Departamento departamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String ciudad) {
		this.nombre = ciudad;
	}

	public String getAltitud() {
		return altitud;
	}

	public void setAltitud(String altitud) {
		this.altitud = altitud;
	}
	
		
	public Clima getClima() {
		return clima;
	}

	public void setClima(Clima clima) {
		this.clima = clima;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	private static final long serialVersionUID = 1L;

}
