package com.fundases.springboot.backend.apirest.fundases.models.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundases.springboot.backend.apirest.fundases.models.dao.ICiudadDao;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Departamento;
import com.fundases.springboot.backend.apirest.fundases.models.entity.Clima;



@Service
public class CiudadServielmpl implements ICiudadService {
	
	@Autowired
	private ICiudadDao cuidadDao;



	@Override
	@Transactional(readOnly = true)
	public List<Clima> findAllClimas() {
		return cuidadDao.findAllClimas();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Departamento> findAllDepartamentos() {
		return cuidadDao.findAllDepartamentos();
	}
	

}

