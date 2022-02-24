package com.fundases.springboot.backend.apirest.fundases.models.entity;

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

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "proveedores")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 15, message = "debe tener un  tamaño entre 4 y 15 caracteres")
	@Column(nullable = false)
	private String documento;
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 150, message = "debe tener un  tamaño entre 4 y 150 caracteres")
	@Column(nullable = false)
	private String nombre;
	@NotEmpty(message = "no puede estar vacio")
	private String telefono;
	@NotEmpty(message = "no puede estar vacio")
	private String celular;
	@NotEmpty(message = "no puede estar vacio")
	@Email(message = "no es una dirección de correo bien formada")
	@Column(nullable = false, unique = false)
	private String email;
	@NotEmpty(message = "no puede estar vacio")
	private String direccion;

	@NotNull(message = "La fecha No puede estar vacia")
	@Temporal(TemporalType.DATE)
	private Date fecha_ingreso;

	@NotNull(message = "No puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ciudad")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Ciudad ciudad;

	@NotNull(message = "No puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_documento")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Tipo_Documento tipo_documento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Tipo_Documento getTipo_Documento() {
		return tipo_documento;
	}

	public void setTipo_Documento(Tipo_Documento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	private static final long serialVersionUID = 1L;
}
