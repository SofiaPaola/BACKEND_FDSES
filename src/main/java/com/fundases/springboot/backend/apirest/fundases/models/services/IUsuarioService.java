package com.fundases.springboot.backend.apirest.fundases.models.services;

import com.fundases.springboot.backend.apirest.fundases.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
