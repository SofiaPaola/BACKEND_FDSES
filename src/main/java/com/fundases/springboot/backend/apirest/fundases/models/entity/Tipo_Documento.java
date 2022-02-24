package com.fundases.springboot.backend.apirest.fundases.models.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_documento")
public class Tipo_Documento  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tipo_documento;
	public Long getId_tipo_documento() {
		return id_tipo_documento;
	}


	public void setId_tipo_documento(Long id_tipo_documento) {
		this.id_tipo_documento = id_tipo_documento;
	}


	public String getTipo_documento() {
		return tipo_documento;
	}


	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}


	private String tipo_documento;
	
	
	private static final long serialVersionUID = 1L;
}
