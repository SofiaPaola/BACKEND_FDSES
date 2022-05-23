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
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
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
	//@Column(nullable = false)
	private String contacto;
	
	@NotEmpty(message = "no puede estar vacio")
	//@Column(nullable = false)
	private String cargo;
	
	@NotEmpty(message = "no puede estar vacio")
	private String telefono;
	
	@NotEmpty(message = "no puede estar vacio")
	private String celular;
	
	@NotEmpty(message = "no puede estar vacio")
	//@Email(message = "no es una dirección de correo bien formada")
	@Column(nullable = false, unique = false)
	private String email;
	
	@NotEmpty(message = "no puede estar vacio")
	private String direccion;

	@NotNull(message = "La fecha No puede estar vacia")
	@Temporal(TemporalType.DATE)
	private Date fecha_ingreso;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ciudad")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Ciudad ciudad;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_documento")	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoDocumento tipo_documento;
	
	//@NotEmpty(message = "no puede estar vacio")
	private Long activo;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 2, max = 2, message = "la respuesta tiene que ser SI o NO")
	private String contratista;
	
	//@NotEmpty(message = "no puede estar vacio")
	private Long disponibilidad;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 2, max = 2, message = "la respuesta tiene que ser SI o NO")
	private String critico;
	
	private String archivo_arl;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 2, max = 2, message = "La respuesta tiene que ser SI o NO")
	private String afiliado_sgr;
	
	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 2, max = 2, message = "La respuesta tiene que ser SI o NO")
	private String implementa_sgsst;
	
	private String observaciones;
	
	private Long id_forma_pago;

	public Long getId() {
		return id;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public Long getActivo() {
		return activo;
	}

	public void setActivo(Long activo) {
		this.activo = activo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getContratista() {
		return contratista;
	}

	public void setContratista(String contratista) {
		this.contratista = contratista;
	}
	
	public Long getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Long disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getCritico() {
		return critico;
	}

	public void setCritico(String critico) {
		this.critico = critico;
	}

	public String getArchivo_arl() {
		return archivo_arl;
	}

	public void setArchivo_arl(String archivo_arl) {
		this.archivo_arl = archivo_arl;
	}

	public String getAfiliado_sgr() {
		return afiliado_sgr;
	}

	public void setAfiliado_sgr(String afiliado_sgr) {
		this.afiliado_sgr = afiliado_sgr;
	}

	public String getImplementa_sgsst() {
		return implementa_sgsst;
	}

	public void setImplementa_sgsst(String implementa_sgsst) {
		this.implementa_sgsst = implementa_sgsst;
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
	
	public TipoDocumento getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(TipoDocumento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public Long getId_forma_pago() {
		return id_forma_pago;
	}

	public void setId_forma_pago(Long id_forma_pago) {
		this.id_forma_pago = id_forma_pago;
	}

	private static final long serialVersionUID = 1L;
	
}