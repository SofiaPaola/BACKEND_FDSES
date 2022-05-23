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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "comp_elemenetos")
public class CompraElemento implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_elemento")
	private Long id;
	
	
	@NotEmpty(message = "no puede ser vacio")
	private String codigo;
	
	@NotEmpty(message = "no puede ser vacio")
	private String nombre;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unidad_medida")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Unidad unidades;
	
	private String tiempo_vencimiento;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraCategoria comp_categoria;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTiempo_vencimiento() {
		return tiempo_vencimiento;
	}

	public void setTiempo_vencimiento(String tiempo_vencimiento) {
		this.tiempo_vencimiento = tiempo_vencimiento;
	}

	public CompraCategoria getComp_categoria() {
		return comp_categoria;
	}

	public void setComp_categoria(CompraCategoria comp_categoria) {
		this.comp_categoria = comp_categoria;
	}

	public Unidad getUnidades() {
		return unidades;
	}

	public void setUnidades(Unidad unidades) {
		this.unidades = unidades;
	}

	private static final long serialVersionUID = 1L;
	
}
