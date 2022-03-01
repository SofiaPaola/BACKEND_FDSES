package com.fundases.springboot.backend.apirest.fundases.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "usuarioEmail")
	private String username;
	
	@Column(name = "clave")
	private String password;
	
	private String nombre;
	
	@Column(name = "FechaUltimoIngreso")
	@Temporal(TemporalType.DATE)
	private Date fecha_ultimo_ingreso;
	
	@Column(name = "FechaActivacionInicial")
	@Temporal(TemporalType.DATE)
	private Date fecha_activacion_inicial;
	
	@Column(name = "FechaActivacionFinal")
	@Temporal(TemporalType.DATE)
	private Date fecha_activacion_final;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "rol_usuario", joinColumns = @JoinColumn(name = "id_usuario"), 
	inverseJoinColumns = @JoinColumn(name = "id_rol"), 
	uniqueConstraints = {@UniqueConstraint(columnNames = { "id_usuario", "id_rol"})})
	private List<Rol> roles;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_ultimo_ingreso() {
		return fecha_ultimo_ingreso;
	}

	public void setFecha_ultimo_ingreso(Date fecha_ultimo_ingreso) {
		this.fecha_ultimo_ingreso = fecha_ultimo_ingreso;
	}

	public Date getFecha_activacion_inicial() {
		return fecha_activacion_inicial;
	}

	public void setFecha_activacion_inicial(Date fecha_activacion_inicial) {
		this.fecha_activacion_inicial = fecha_activacion_inicial;
	}

	public Date getFecha_activacion_final() {
		return fecha_activacion_final;
	}

	public void setFecha_activacion_final(Date fecha_activacion_final) {
		this.fecha_activacion_final = fecha_activacion_final;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	private static final long serialVersionUID = 1L;

}
