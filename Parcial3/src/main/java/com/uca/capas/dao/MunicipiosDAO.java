package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Municipios;

public interface MunicipiosDAO {
	
	public List<Municipios> findAll() throws DataAccessException;
	
	public Municipios findOne(Integer code) throws DataAccessException;


}
