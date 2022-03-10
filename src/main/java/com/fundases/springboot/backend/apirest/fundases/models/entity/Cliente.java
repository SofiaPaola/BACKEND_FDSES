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
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;

	@NotEmpty(message = "no puede ser vacio")
	@Column(nullable=false, unique=true)
	private String documento;

	@NotEmpty(message = "no puede ser vacio")
	@Size(min=5, max=100)
	private String nombre;

	@NotEmpty(message = "no puede ser vacio")
	private String contacto;

	@NotEmpty(message = "no puede ser vacio")
	private String cargo;

	@NotEmpty(message = "no puede ser vacio")
	private String direccion;

	@NotEmpty(message = "no puede ser vacio")
	private String telefono;

	private String telefono1;
	
	@NotEmpty(message = "no puede ser vacio")
	private String celular;

	@NotEmpty(message = "no puede ser vacio")
	@Email
	private String email;

	@Temporal(TemporalType.DATE)
	private Date fecha_ingreso;
	
	@NotEmpty(message = "no puede ser vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ciudad")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Ciudad ciudad;
	
	@NotEmpty(message = "no puede ser vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_documento")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoDocumento tipo_documento;

	private String observaciones;

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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
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

	public TipoDocumento getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(TipoDocumento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	private static final long serialVersionUID = 1L;

}
