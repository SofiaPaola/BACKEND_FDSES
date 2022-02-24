package com.fundases.springboot.backend.apirest.fundases.models.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciudades")

public class Ciudad implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ciudad;
	private String ciudad;
	private Long altitud;
	//private Long id_departamento;	
	//private Long id_clima;



	private static final long serialVersionUID = 1L;



	public Long getId_ciudad() {
		return id_ciudad;
	}



	public void setId_ciudad(Long id_ciudad) {
		this.id_ciudad = id_ciudad;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public Long getAltitud() {
		return altitud;
	}



	public void setAltitud(Long altitud) {
		this.altitud = altitud;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
