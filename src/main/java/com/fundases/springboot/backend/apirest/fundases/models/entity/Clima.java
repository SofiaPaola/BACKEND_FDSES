package com.fundases.springboot.backend.apirest.fundases.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name="climas")
public class Clima implements Serializable {
	
	@Id
	@Column(name = "id_clima")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 30)
	private String clima;
	
	private static final long serialVersionUID = 1L;
}


