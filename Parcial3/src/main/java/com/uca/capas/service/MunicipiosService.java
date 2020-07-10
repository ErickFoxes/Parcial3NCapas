package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Municipios;

public interface MunicipiosService {
	
	public List<Municipios> findAll() throws DataAccessException;
	
	public Municipios findOne(Integer code) throws DataAccessException;

}
