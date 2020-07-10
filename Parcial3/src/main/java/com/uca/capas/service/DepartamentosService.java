package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Departamentos;

public interface DepartamentosService {

	public List<Departamentos> findAll() throws DataAccessException;
	
	public Departamentos findOne(Integer code) throws DataAccessException;
	
}
