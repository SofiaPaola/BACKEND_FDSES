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
@Table(name = "comp_categorias_proveedores")
public class CompraCategoriaProveedor implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_categoria_proveedor")
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private CompraCategoria comp_categoria;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_proveedor")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Proveedor proveedores;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CompraCategoria getComp_categoria() {
		return comp_categoria;
	}

	public void setComp_categoria(CompraCategoria comp_categoria) {
		this.comp_categoria = comp_categoria;
	}

	public Proveedor getProveedores() {
		return proveedores;
	}

	public void setProveedores(Proveedor proveedores) {
		this.proveedores = proveedores;
	}

	private static final long serialVersionUID = 1L;
}
