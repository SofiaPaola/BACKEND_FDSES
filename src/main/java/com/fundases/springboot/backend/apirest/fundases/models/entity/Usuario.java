package com.fundases.springboot.backend.apirest.fundases.models.entity;

import java.io.Serializable;
//import java.util.Date;
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
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(name = "usuarioEmail")
	private String username;
		
	private String password;
	
	private String nombre;
	
	private Boolean enabled;
	
	//@Temporal(TemporalType.DATE)
	//private Date FechaUltimoIngreso;
	
	
	//@Temporal(TemporalType.DATE)
	//private Date FechaActivacionInicial;
	
	
	//@Temporal(TemporalType.DATE)
	//private Date FechaActivacionFinal;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "id_usuario"), 
	inverseJoinColumns = @JoinColumn(name = "id_rol"), 
	uniqueConstraints = {@UniqueConstraint(columnNames = { "id_usuario", "id_rol"})})
	private List<Role> rol;
	
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

	
	
	/*public Date getFechaUltimoIngreso() {
		return FechaUltimoIngreso;
	}

	public void setFechaUltimoIngreso(Date fechaUltimoIngreso) {
		FechaUltimoIngreso = fechaUltimoIngreso;
	}

	public Date getFechaActivacionInicial() {
		return FechaActivacionInicial;
	}

	public void setFechaActivacionInicial(Date fechaActivacionInicial) {
		FechaActivacionInicial = fechaActivacionInicial;
	}

	public Date getFechaActivacionFinal() {
		return FechaActivacionFinal;
	}

	public void setFechaActivacionFinal(Date fechaActivacionFinal) {
		FechaActivacionFinal = fechaActivacionFinal;
	}*/

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return rol;
	}

	public void setRoles(List<Role> rol) {
		this.rol = rol;
	}

	private static final long serialVersionUID = 1L;

}
